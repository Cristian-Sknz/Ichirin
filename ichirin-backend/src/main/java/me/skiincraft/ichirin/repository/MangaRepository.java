package me.skiincraft.ichirin.repository;

import me.skiincraft.ichirin.models.manga.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
