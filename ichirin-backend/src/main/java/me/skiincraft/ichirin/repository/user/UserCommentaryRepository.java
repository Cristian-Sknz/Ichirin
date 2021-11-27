package me.skiincraft.ichirin.repository.user;

import me.skiincraft.ichirin.entity.user.IchirinUser;
import me.skiincraft.ichirin.entity.user.UserCommentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentaryRepository extends JpaRepository<UserCommentary, Long> {

    List<UserCommentary> findAllByUser(IchirinUser user);

}