package me.skiincraft.ichirin.repository.user;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserFavorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {

    @Query("SELECT f FROM UserFavorite f LEFT JOIN FETCH f.mangas WHERE f.user = :user")
    UserFavorite findByUser(@Param("user") IchirinUser user);

    @Query("SELECT f FROM UserFavorite f LEFT JOIN FETCH f.mangas WHERE f.id = :id")
    Optional<UserFavorite> findById(@Param("id") long id);

    @Query("SELECT f FROM UserFavorite f LEFT JOIN f.mangas mangas WHERE mangas = :manga")
    Collection<UserFavorite> findAllByManga(@Param("manga") Manga mangas);

    @Query("SELECT f FROM UserFavorite f LEFT JOIN f.mangas mangas WHERE mangas = :manga")
    Page<UserFavorite> findAllByManga(@Param("manga") Manga mangas, Pageable pageable);
    
}
