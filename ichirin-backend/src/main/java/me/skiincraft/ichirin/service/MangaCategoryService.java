package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaCategory;
import me.skiincraft.ichirin.repository.manga.MangaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MangaCategoryService {

    @Autowired
    private MessageSource source;
    private final MangaService mangaService;
    private final MangaCategoryRepository categoryRepository;

    @Autowired
    public MangaCategoryService(MangaService mangaService, MangaCategoryRepository categoryRepository) {
        this.mangaService = mangaService;
        this.categoryRepository = categoryRepository;
    }

    public Collection<MangaCategory> getCategories() {
        return categoryRepository.findAll();
    }

    public MangaCategory createCategory(String name) {
        return categoryRepository.save(new MangaCategory(name));
    }

    public MangaCategory getCategory(long id) {
        var optional = categoryRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IchirinNotFoundException("exception.category.not-found", source);
        }
        return optional.get();
    }

    public void deleteCategory(long categoryId) {
        var category = getCategory(categoryId);
        var mangas = mangaService.getRepository().findAllByCategory(category)
                .stream().peek((manga) -> manga.getCategory().remove(category))
                .collect(Collectors.toList());

        if (!mangas.isEmpty()) {
            mangaService.getRepository().saveAll(mangas);
        }
        categoryRepository.delete(category);
    }

    public Manga addCategoryToManga(long mangaId, long categoryId) {
        var manga = mangaService.getManga(mangaId);
        manga.getCategory().add(getCategory(categoryId));

        return mangaService.getRepository().save(manga);
    }

    public Manga removeCategoryFromManga(long mangaId, long categoryId) {
        var manga = mangaService.getManga(mangaId);
        manga.getCategory().remove(getCategory(categoryId));

        return mangaService.getRepository().save(manga);
    }
}
