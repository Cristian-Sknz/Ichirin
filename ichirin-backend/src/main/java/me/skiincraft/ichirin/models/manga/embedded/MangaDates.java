package me.skiincraft.ichirin.models.manga.embedded;

import me.skiincraft.ichirin.data.MangaDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Embeddable
public class MangaDates {

    @CreatedDate
    private OffsetDateTime createdTime;
    private LocalDateTime releaseDate;
    @LastModifiedDate
    private OffsetDateTime lastUpdate;

    public MangaDates() {
    }

    public MangaDates(MangaDTO dto) {
        this.releaseDate = LocalDateTime.parse(dto.getReleaseDate());
        this.createdTime = this.lastUpdate = OffsetDateTime.now();
    }

    public OffsetDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(OffsetDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
