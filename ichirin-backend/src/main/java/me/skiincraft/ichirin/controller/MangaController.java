package me.skiincraft.ichirin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.skiincraft.ichirin.entity.manga.MangaChapter;
import me.skiincraft.ichirin.entity.manga.MangaComments;
import me.skiincraft.ichirin.entity.user.UserCommentary;
import me.skiincraft.ichirin.models.data.DataType;
import me.skiincraft.ichirin.models.data.manga.MangaData;
import me.skiincraft.ichirin.models.data.manga.MangaFavorite;
import me.skiincraft.ichirin.models.data.manga.MangaCompact;
import me.skiincraft.ichirin.models.dto.MangaChapterDTO;
import me.skiincraft.ichirin.models.dto.MangaDTO;
import me.skiincraft.ichirin.service.CommentaryService;
import me.skiincraft.ichirin.service.FavoriteService;
import me.skiincraft.ichirin.service.MangaCategoryService;
import me.skiincraft.ichirin.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public Page<? extends MangaCompact> getMangas(@RequestParam(required = false) DataType type,
                                                  Pageable pageable) {
        return mangaService.getMangas(type, pageable);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ROLE_EDITOR')")
    public MangaData newManga(@RequestBody @Validated MangaDTO dto) {
        return mangaService.createManga(dto);
    }

    @GetMapping("/{mangaId}")
    public MangaCompact getManga(@RequestParam(required = false) DataType type,
                                 @PathVariable Long mangaId) {
        return mangaService.getManga(type, mangaId);
    }

    @DeleteMapping("/{mangaId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Object deleteManga(@PathVariable Long mangaId) {
        mangaService.deleteManga(mangaId);
        return new ObjectMapper().createObjectNode().put("response", "ok");
    }

    @GetMapping("/category/{category}")
    public Page<? extends MangaCompact> getMangaByCategory(@RequestParam(required = false) DataType type,
                                                           @PathVariable String category,
                                                           Pageable pageable) {
        if (category.matches("\\d+$")) {
            return categoryService.getMangasByCategory(type, Long.parseLong(category), pageable);
        }
        return categoryService.getMangasByCategory(type, category, pageable);
    }

    @PostMapping("/{mangaId}/chapters")
    @PreAuthorize("hasAuthority('ROLE_EDITOR')")
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
    public MangaFavorite getMangaFavorite(@PathVariable Long mangaId,
                                          Pageable pageable) {
        return favoriteService.getMangaFavorite(mangaId, pageable);
    }

    @PostMapping("/{mangaId}/category/{categoryId}")
    @PreAuthorize("hasAuthority('ROLE_EDITOR')")
    public MangaCompact addCategoryToManga(@RequestParam(required = false) DataType type,
                                           @PathVariable Long mangaId,
                                           @PathVariable Long categoryId) {
        return categoryService.addCategoryToManga(type, mangaId, categoryId);
    }

    @DeleteMapping("/{mangaId}/category/{categoryId}")
    @PreAuthorize("hasAuthority('ROLE_EDITOR')")
    public MangaCompact removeCategoryFromManga(@RequestParam(required = false) DataType type,
                                                @PathVariable Long mangaId,
                                                @PathVariable Long categoryId) {
        return categoryService.removeCategoryFromManga(type, mangaId, categoryId);
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

