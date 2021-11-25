package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.manga.MangaChapterDTO;
import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaChapter;
import me.skiincraft.ichirin.repository.manga.MangaChapterRepository;
import me.skiincraft.ichirin.repository.manga.MangaRepository;
import me.skiincraft.ichirin.util.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MangaService {

    private final MangaRepository repository;
    private final MangaChapterRepository chapterRepository;
    private final ApplicationServices applicationServices;

    @Autowired
    private MessageSource source;

    @Autowired
    public MangaService(MangaRepository repository,
                        MangaChapterRepository chapterRepository,
                        ApplicationServices applicationServices) {
        this.repository = repository;
        this.chapterRepository = chapterRepository;
        this.applicationServices = applicationServices;
    }

    public Page<Manga> getMangas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Manga getManga(long mangaId) {
        return repository.findById(mangaId)
                .orElseThrow(() -> new IchirinNotFoundException("exception.manga.not-found", source));
    }

    public Manga createManga(MangaDTO dto) {
        return repository.save(new Manga(dto));
    }

    public void deleteManga(Long mangaId) {
        Manga manga = getManga(mangaId);
        applicationServices.getMangaRelationshipService()
                .removeAllRelations(manga);
        repository.delete(manga);
    }

    public Page<MangaChapter> getMangaChapters(long mangaId, Pageable pageable) {
        return chapterRepository.findAllByManga(getManga(mangaId), pageable);
    }

    public MangaChapter getMangaChapter(long mangaId, float chapter) {
        var optional = chapterRepository.findByMangaAndChapter(getManga(mangaId), chapter);
        if (optional.isEmpty()) {
            throw new IchirinNotFoundException("exception.manga.not-found", source);
        }

        return optional.get();
    }

    public MangaChapter createMangaChapter(long mangaId, MangaChapterDTO dto) {
        return chapterRepository.save(new MangaChapter(getManga(mangaId), dto));
    }

    public Page<Manga> getMangasByCategory(long categoryId, Pageable pageable) {
        return repository.findAllByCategoryId(categoryId, pageable);
    }

    public MangaRepository getRepository() {
        return repository;
    }
}
