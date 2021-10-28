package me.skiincraft.ichirin.repository;

import me.skiincraft.ichirin.models.user.IchirinUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IchirinUserRepository extends JpaRepository<IchirinUser, Long> {
}
