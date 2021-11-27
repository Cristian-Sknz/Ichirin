package me.skiincraft.ichirin.repository.user;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    @Query("SELECT u FROM UserHistory u LEFT JOIN FETCH u.mangas WHERE u.user = :user")
    UserHistory findByUser(@Param("user") IchirinUser user);

    @Query("SELECT u FROM UserHistory u LEFT JOIN FETCH u.mangas WHERE u.id = :id")
    Optional<UserHistory> findById(@Param("id") long id);

    @Query("select u from UserHistory u left join u.mangas mangas where mangas = :manga")
    Collection<UserHistory> findAllByManga(@Param("manga") Manga manga);

}
