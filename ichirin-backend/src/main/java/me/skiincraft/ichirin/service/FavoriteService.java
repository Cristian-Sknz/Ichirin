package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.user.UserFavorite;
import me.skiincraft.ichirin.repository.user.UserFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private final UserService userService;
    private final MangaService mangaService;
    private final UserFavoriteRepository ufRepository;

    @Autowired
    public FavoriteService(UserService userService,
                           MangaService mangaService,
                           UserFavoriteRepository ufRepository) {
        this.userService = userService;
        this.mangaService = mangaService;
        this.ufRepository = ufRepository;
    }

    public UserFavorite getUserFavorite(long userId) {
        return ufRepository.findByUser(userService.getUser(userId));
    }

    public Page<UserFavorite> getMangaFavorite(long mangaId, Pageable pageable) {
        return ufRepository.findAllByManga(mangaService.getManga(mangaId), pageable);
    }

    public Collection<UserFavorite> getMangaFavorite(long mangaId) {
        return ufRepository.findAllByManga(mangaService.getManga(mangaId));
    }

    public UserFavorite addUserFavorite(long userId, long mangaId) {
        var favorite = ufRepository.findByUser(userService.getUser(userId));
        favorite.addManga(mangaService.getManga(mangaId));
        return ufRepository.save(favorite);
    }

    public UserFavorite removeUserFavorite(long userId, long mangaId) {
        var favorite = ufRepository.findByUser(userService.getUser(userId));
        favorite.removeManga(mangaService.getManga(mangaId));
        return ufRepository.save(favorite);
    }

    public void removeUserFavorite(Manga manga) {
        var favorites = ufRepository.findAllByManga(manga);
        ufRepository.saveAll(favorites.stream()
                .peek((favorite) -> favorite.removeManga(manga))
                .collect(Collectors.toList()));
    }

    public void removeUserFavorite(long mangaId) {
        removeUserFavorite(mangaService.getManga(mangaId));
    }
}
