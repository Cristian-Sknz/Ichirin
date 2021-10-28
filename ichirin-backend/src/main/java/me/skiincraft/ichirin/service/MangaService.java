package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.data.manga.MangaChapterDTO;
import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaChapter;
import me.skiincraft.ichirin.repository.MangaChapterRepository;
import me.skiincraft.ichirin.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MangaService {

    private final MangaRepository repository;
    private final MangaChapterRepository chapterRepository;

    @Autowired
    public MangaService(MangaRepository repository, MangaChapterRepository chapterRepository) {
        this.repository = repository;
        this.chapterRepository = chapterRepository;
    }

    public Page<Manga> getMangas(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Manga getManga(long mangaId) {
        return repository.findById(mangaId).get();
    }

    public Manga createManga(MangaDTO dto) {
        return repository.save(new Manga(dto));
    }

    public Page<MangaChapter> getMangaChapters(long mangaId, Pageable pageable) {
        return chapterRepository.findAllByManga(getManga(mangaId), pageable);
    }

    public MangaChapter getMangaChapter(long mangaId, float chapter) {
        return chapterRepository.findByMangaAndChapter(getManga(mangaId), chapter).get();
    }

    public MangaChapter createMangaChapter(long mangaId, MangaChapterDTO dto) {
        return chapterRepository.save(new MangaChapter(getManga(mangaId), dto));
    }

}
