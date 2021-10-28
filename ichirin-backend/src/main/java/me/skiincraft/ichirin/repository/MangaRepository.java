package me.skiincraft.ichirin.repository;

import me.skiincraft.ichirin.models.manga.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {
}
