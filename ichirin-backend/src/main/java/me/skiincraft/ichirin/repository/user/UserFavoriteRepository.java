package me.skiincraft.ichirin.repository.user;

import me.skiincraft.ichirin.models.user.UserFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {

    @Query("SELECT f FROM UserFavorite f LEFT JOIN FETCH f.mangas WHERE f.id = :id")
    Optional<UserFavorite> findById(@Param("id") long id);
}
