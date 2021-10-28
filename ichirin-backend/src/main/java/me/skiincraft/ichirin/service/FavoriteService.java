package me.skiincraft.ichirin.service;

import me.skiincraft.ichirin.models.manga.MangaFavorite;
import me.skiincraft.ichirin.models.user.UserFavorite;
import me.skiincraft.ichirin.repository.manga.MangaFavoriteRepository;
import me.skiincraft.ichirin.repository.user.UserFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    private final MangaFavoriteRepository mfRepository;
    private final UserFavoriteRepository ufRepository;

    @Autowired
    public FavoriteService(MangaFavoriteRepository mfRepository, UserFavoriteRepository ufRepository) {
        this.mfRepository = mfRepository;
        this.ufRepository = ufRepository;
    }

    public UserFavorite getUserFavorite(long userId) {
        return ufRepository.findById(userId).get();
    }

    public MangaFavorite getMangaFavorite(long mangaId) {
        return mfRepository.findById(mangaId).get();
    }

    public UserFavorite addToUserFavorites(long userId, long mangaId) {
        var favorite = ufRepository.findById(userId).get();
        favorite.getMangas().add(mfRepository.findById(mangaId).get());
        return ufRepository.save(favorite);
    }

    public UserFavorite removeFromUserFavorites(Long userId, Long mangaId) {
        var favorite = ufRepository.findById(userId).get();
        favorite.getMangas().removeIf((f) -> f.getId() == mangaId);
        return ufRepository.save(favorite);
    }
}
