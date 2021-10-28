package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.data.manga.MangaChapterDTO;
import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaChapter;
import me.skiincraft.ichirin.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mangas")
public class MangaController {

    private final MangaService mangaService;

    @Autowired
    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("")
    public Page<Manga> getMangas(Pageable pageable) {
        return mangaService.getMangas(pageable);
    }

    @GetMapping("/{mangaId}")
    public Manga getManga(int id) {
        return null;
    }

    @PostMapping("")
    public Manga newManga(@RequestBody @Validated MangaDTO dto) {
        return mangaService.createManga(dto);
    }

    @PostMapping("/{mangaId}/chapters")
    public MangaChapter newMangaChapter(@PathVariable Long mangaId, @RequestBody @Validated MangaChapterDTO dto) {
        return mangaService.createMangaChapter(mangaId, dto);
    }

    @GetMapping("/{mangaId}/chapters")
    public Page<MangaChapter> getMangaChapters(@PathVariable(name = "mangaId") long mangaId, Pageable pageable) {
        return mangaService.getMangaChapters(mangaId, pageable);
    }

    @GetMapping("/{mangaId}/chapters/{chapter}")
    public MangaChapter getMangaChapter(@PathVariable Long mangaId, @PathVariable Float chapter) {
        return mangaService.getMangaChapter(mangaId, chapter);
    }

}

