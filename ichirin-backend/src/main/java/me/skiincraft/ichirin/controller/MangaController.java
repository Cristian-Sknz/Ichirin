package me.skiincraft.ichirin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.skiincraft.ichirin.data.manga.MangaChapterDTO;
import me.skiincraft.ichirin.data.manga.MangaDTO;
import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaChapter;
import me.skiincraft.ichirin.models.manga.MangaComments;
import me.skiincraft.ichirin.models.user.UserCommentary;
import me.skiincraft.ichirin.models.user.UserFavorite;
import me.skiincraft.ichirin.service.CommentaryService;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.MangaCategoryService;
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
    private final FavoriteService favoriteService;
    private final MangaCategoryService categoryService;
    private final CommentaryService commentaryService;

    @Autowired
    public MangaController(MangaService mangaService,
                           FavoriteService favoriteService,
                           MangaCategoryService categoryService,
                           CommentaryService commentaryService) {
        this.mangaService = mangaService;
        this.favoriteService = favoriteService;
        this.categoryService = categoryService;
        this.commentaryService = commentaryService;
    }

    @GetMapping("")
    public Page<Manga> getMangas(Pageable pageable) {
        return mangaService.getMangas(pageable);
    }

    @PostMapping("")
    public Manga newManga(@RequestBody @Validated MangaDTO dto) {
        return mangaService.createManga(dto);
    }

    @GetMapping("/{mangaId}")
    public Manga getManga(@PathVariable Long mangaId) {
        return mangaService.getManga(mangaId);
    }

    @DeleteMapping("/{mangaId}")
    public Object deleteManga(@PathVariable Long mangaId) {
        mangaService.deleteManga(mangaId);
        return new ObjectMapper().createObjectNode().put("response", "ok");
        // TODO mudar as respostas de DELETE
    }

    @PostMapping("/{mangaId}/chapters")
    public MangaChapter newMangaChapter(@PathVariable Long mangaId,
                                        @RequestBody @Validated MangaChapterDTO dto) {
        return mangaService.createMangaChapter(mangaId, dto);
    }

    @GetMapping("/{mangaId}/chapters")
    public Page<MangaChapter> getMangaChapters(@PathVariable(name = "mangaId") long mangaId,
                                               Pageable pageable) {
        return mangaService.getMangaChapters(mangaId, pageable);
    }

    @GetMapping("/{mangaId}/chapters/{chapter}")
    public MangaChapter getMangaChapter(@PathVariable Long mangaId,
                                        @PathVariable Float chapter) {
        return mangaService.getMangaChapter(mangaId, chapter);
    }

    @GetMapping("/{mangaId}/favorites")
    public Page<UserFavorite> getMangaFavorite(@PathVariable Long mangaId,
                                               Pageable pageable) {
        return favoriteService.getMangaFavorite(mangaId, pageable);
    }

    @PostMapping("/{mangaId}/category/{categoryId}")
    public Manga addCategoryToManga(@PathVariable Long mangaId,
                                    @PathVariable Long categoryId) {
        return categoryService.addCategoryToManga(mangaId, categoryId);
    }

    @DeleteMapping("/{mangaId}/category/{categoryId}")
    public Manga removeCategoryFromManga(@PathVariable Long mangaId,
                                         @PathVariable Long categoryId) {
        return categoryService.removeCategoryFromManga(mangaId, categoryId);
    }

    @GetMapping("/{mangaId}/comments")
    public MangaComments getMangaComments(@PathVariable Long mangaId) {
        return commentaryService.getMangaComments(mangaId);
    }

    @GetMapping("/{mangaId}/comments/{commentId}")
    public UserCommentary getCommentaryById(@PathVariable Long mangaId,
                                            @PathVariable Long commentId) {
        return commentaryService.getMangaComment(mangaId, commentId);
    }
}

