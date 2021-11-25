package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.models.manga.Manga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangaRelationshipService {

    private final UserHistoryService historyService;
    private final FavoriteService favoriteService;

    @Autowired
    public MangaRelationshipService(UserHistoryService historyService,
                                    FavoriteService favoriteService) {
        this.historyService = historyService;
        this.favoriteService = favoriteService;
    }

    public void removeFromAllHistories(Manga manga) {
        this.historyService.removeManga(manga);
    }

    public void removeFromAllFavorites(Manga manga) {
        this.favoriteService.removeUserFavorite(manga);
    }

    public void removeAllRelations(Manga manga) {
        this.removeFromAllHistories(manga);
        this.removeFromAllFavorites(manga);
    }
}
