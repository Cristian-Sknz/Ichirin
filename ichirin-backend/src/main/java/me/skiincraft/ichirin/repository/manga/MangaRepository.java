package me.skiincraft.ichirin.repository.manga;

import me.skiincraft.ichirin.entity.manga.Manga;
import me.skiincraft.ichirin.entity.manga.MangaCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {

    Collection<Manga> findAllByCategory(MangaCategory category);
    Page<Manga> findAllByCategory(MangaCategory category, Pageable pageable);

    Collection<Manga> findAllByCategoryId(long categoryId);

    Page<Manga> findAllByCategoryId(long categoryId, Pageable pageable);

}
