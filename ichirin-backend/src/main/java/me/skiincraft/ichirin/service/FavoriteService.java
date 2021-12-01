package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserFavorite;
import me.skiincraft.ichirin.models.data.manga.MangaFavorite;
import me.skiincraft.ichirin.models.data.user.UserFavoriteData;
import me.skiincraft.ichirin.repository.user.UserFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public MangaFavorite getMangaFavorite(long mangaId, Pageable pageable) {
        var manga = mangaService.getManga(mangaId);
        List<IchirinUser> users = ufRepository.findAllByManga(manga)
                .stream().map(UserFavorite::getUser)
                .collect(Collectors.toList());

        return MangaFavorite.of(manga, new PageImpl<>(users, pageable, users.size()));
    }

    public UserFavoriteData getUserFavorite(long userId, Pageable pageable) {
        var user = userService.getUser(userId);
        var favorite = ufRepository.findByUser(user);
        return UserFavoriteData.of(user, new ArrayList<>(favorite.getMangas()), pageable);
    }

    public UserFavoriteData addUserFavorite(long userId, long mangaId) {
        var user = userService.getUser(userId);
        var favorite = ufRepository.findByUser(user);
        var manga = mangaService.getManga(mangaId);

        favorite.addManga(manga);
        ufRepository.save(favorite);
        return UserFavoriteData.of(user, new ArrayList<>(favorite.getMangas()), Pageable.unpaged());
    }

    public UserFavoriteData removeUserFavorite(long userId, long mangaId) {
        var user = userService.getUser(userId);
        var favorite = ufRepository.findByUser(user);
        var manga = mangaService.getManga(mangaId);

        favorite.removeManga(manga);
        ufRepository.save(favorite);
        return UserFavoriteData.of(user, new ArrayList<>(favorite.getMangas()), Pageable.unpaged());
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
