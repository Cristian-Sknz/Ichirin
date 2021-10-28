package me.skiincraft.ichirin.repository;

import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaChapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MangaChapterRepository extends JpaRepository<MangaChapter, Long> {

    Page<MangaChapter> findAllByManga(Manga manga, Pageable pageable);
    Optional<MangaChapter> findByMangaAndChapter(Manga manga, Float chapter);
}
