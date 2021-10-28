package me.skiincraft.ichirin.repository;

import me.skiincraft.ichirin.models.user.IchirinUser;
import me.skiincraft.ichirin.models.user.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    UserHistory findByUser(IchirinUser user);

    @Query("SELECT u FROM UserHistory u LEFT JOIN FETCH u.mangas WHERE u.id = :id")
    Optional<UserHistory> findById(@Param("id") long id);
}
