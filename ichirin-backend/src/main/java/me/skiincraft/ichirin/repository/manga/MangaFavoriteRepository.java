package me.skiincraft.ichirin.repository.manga;

import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MangaFavoriteRepository extends JpaRepository<MangaFavorite, Long> {

    @Query("SELECT f FROM MangaFavorite f LEFT JOIN FETCH f.users WHERE f.manga = :manga")
    MangaFavorite findByManga(@Param("manga") Manga manga);

    @Query("SELECT f FROM MangaFavorite f LEFT JOIN FETCH f.users WHERE f.id = :id")
    Optional<MangaFavorite> findById(@Param("id") long id);
}
