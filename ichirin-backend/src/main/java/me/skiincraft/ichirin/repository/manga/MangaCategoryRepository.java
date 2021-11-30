package me.skiincraft.ichirin.repository.manga;

import me.skiincraft.ichirin.entity.manga.MangaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MangaCategoryRepository extends JpaRepository<MangaCategory, Long> {

    Optional<MangaCategory> findByNameIgnoreCase(String category);

}
