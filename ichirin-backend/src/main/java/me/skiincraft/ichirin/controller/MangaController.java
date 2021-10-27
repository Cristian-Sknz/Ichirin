package me.skiincraft.ichirin.controller;

import me.skiincraft.ichirin.data.MangaDTO;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaChapter;
import me.skiincraft.ichirin.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Manga newManga(@Validated MangaDTO dto) {
        return null;
    }

    @PostMapping("/{mangaId}/chapters")
    public MangaChapter newMangaChapter(int mangaId/*, MangaChapterDTO*/) {
        return null;
    }

}

