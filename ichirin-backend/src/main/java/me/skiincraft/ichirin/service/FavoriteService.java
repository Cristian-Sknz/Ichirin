package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.models.manga.MangaFavorite;
import me.skiincraft.ichirin.models.user.UserFavorite;
import me.skiincraft.ichirin.repository.manga.MangaFavoriteRepository;
import me.skiincraft.ichirin.repository.user.UserFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    private final UserService userService;
    private final MangaService mangaService;
    private final MangaFavoriteRepository mfRepository;
    private final UserFavoriteRepository ufRepository;

    @Autowired
    public FavoriteService(UserService userService,
                           MangaService mangaService,
                           MangaFavoriteRepository mfRepository,
                           UserFavoriteRepository ufRepository) {
        this.userService = userService;
        this.mangaService = mangaService;
        this.mfRepository = mfRepository;
        this.ufRepository = ufRepository;
    }

    public UserFavorite getUserFavorite(long userId) {
        return ufRepository.findByUser(userService.getUser(userId));
    }

    public MangaFavorite getMangaFavorite(long mangaId) {
        return mfRepository.findByManga(mangaService.getManga(mangaId));
    }

    public UserFavorite addToUserFavorites(long userId, long mangaId) {
        var favorite = ufRepository.findByUser(userService.getUser(userId));
        favorite.getMangas().add(mfRepository.findByManga(mangaService.getManga(mangaId)));
        return ufRepository.save(favorite);
    }

    public UserFavorite removeFromUserFavorites(Long userId, Long mangaId) {
        var favorite = ufRepository.findByUser(userService.getUser(userId));
        favorite.getMangas().removeIf((f) -> f.getId() == mangaId);
        return ufRepository.save(favorite);
    }
}
