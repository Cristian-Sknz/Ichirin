package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.manga.MangaCategory;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.manga.MangaData;
import me.skiincraft.ichirin.models.data.manga.MangaShort;
import me.skiincraft.ichirin.models.dto.MangaChapterDTO;
import me.skiincraft.ichirin.models.dto.MangaDTO;
import me.skiincraft.ichirin.exception.IchirinNotFoundException;
import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaChapter;
import me.skiincraft.ichirin.repository.manga.MangaChapterRepository;
import me.skiincraft.ichirin.repository.manga.MangaRepository;
import me.skiincraft.ichirin.util.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

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

    public Page<? extends MangaShort> getMangas(DataType type, Pageable pageable) {
        return repository.findAll(pageable).map(getFunctionByType(type));
    }

    public Manga getManga(long mangaId) {
        return repository.findById(mangaId)
                .orElseThrow(() -> new IchirinNotFoundException("exception.manga.not-found", source));
    }

    public MangaShort getManga(DataType type, long mangaId) {
        return getFunctionByType(type).apply(getManga(mangaId));
    }

    public MangaData createManga(MangaDTO dto) {
        return MangaData.of(repository.save(new Manga(dto)), Collections.emptyList());
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

    public Page<? extends MangaShort> getMangasByCategory(DataType type, MangaCategory category, Pageable pageable) {
        return repository.findAllByCategory(category, pageable).map(getFunctionByType(type));
    }

    public Function<Manga, ? extends MangaShort> getFunctionByType(DataType type,
                                                                   Function<Manga, MangaShort> ifShort,
                                                                  Function<Manga, MangaData> ifFull) {
        return type == DataType.FULL ? ifFull : ifShort;
    }

    public Function<Manga, ? extends MangaShort> getFunctionByType(DataType type) {
        return getFunctionByType(type, MangaShort::of, (manga) -> MangaData.of(manga, chapterRepository.findAllByManga(manga)));
    }

    public MangaRepository getRepository() {
        return repository;
    }
}
