package me.skiincraft.ichirin.repository.manga;

import me.skiincraft.ichirin.models.manga.Manga;
import me.skiincraft.ichirin.models.manga.MangaComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaCommentsRepository extends JpaRepository<MangaComments, Long> {

    MangaComments findByManga(Manga manga);

    @Query("SELECT c FROM MangaComments c LEFT JOIN FETCH c.userCommentaries WHERE c.manga = :manga")
    MangaComments findByMangaAndFetch(@Param("manga") Manga manga);
}