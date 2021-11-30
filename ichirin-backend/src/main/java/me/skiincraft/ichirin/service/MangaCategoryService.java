package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.entity.manga.MangaCategory;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.repository.manga.MangaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public MangaCategory getCategory(String category) {
        return categoryRepository.findByNameIgnoreCase(category)
                .orElseThrow(() -> new IchirinNotFoundException("exception.category.not-found", source));
    }

    public MangaCategory getCategory(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IchirinNotFoundException("exception.category.not-found", source));
    }

    public Page<? extends MangaShort> getMangasByCategory(DataType type, long category, Pageable pageable) {
        return mangaService.getMangasByCategory(type, getCategory(category), pageable);
    }

    public Page<? extends MangaShort> getMangasByCategory(DataType type, String category, Pageable pageable) {
        return mangaService.getMangasByCategory(type, getCategory(category), pageable);
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

    public MangaShort addCategoryToManga(DataType type, long mangaId, long categoryId) {
        var manga = mangaService.getManga(mangaId);
        manga.getCategory().add(getCategory(categoryId));
        return mangaService.getFunctionByType(type).apply(mangaService.getRepository().save(manga));
    }

    public MangaShort removeCategoryFromManga(DataType type, long mangaId, long categoryId) {
        var manga = mangaService.getManga(mangaId);
        manga.getCategory().remove(getCategory(categoryId));

        return mangaService.getFunctionByType(type).apply(mangaService.getRepository().save(manga));
    }
}
