package me.skiincraft.ichirin.repository.manga;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaChapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MangaChapterRepository extends JpaRepository<MangaChapter, Long> {

    List<MangaChapter> findAllByManga(Manga manga);
    Page<MangaChapter> findAllByManga(Manga manga, Pageable pageable);
    Optional<MangaChapter> findByMangaAndChapter(Manga manga, Float chapter);
}
