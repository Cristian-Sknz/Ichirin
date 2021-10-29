package me.skiincraft.ichirin.repository.manga;

import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {

    List<Manga> findAllByCategory(MangaCategory category);
    Page<Manga> findAllByCategoryId(long categoryId, Pageable pageable);
    List<Manga> findAllByCategoryId(long categoryId);
}
