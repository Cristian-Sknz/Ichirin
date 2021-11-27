package me.skiincraft.ichirin.repository.user;

import me.skiincraft.ichirin.models.user.IchirinUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IchirinUserRepository extends JpaRepository<IchirinUser, Long> {

    Optional<IchirinUser> findByEmailIgnoreCase(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

}
