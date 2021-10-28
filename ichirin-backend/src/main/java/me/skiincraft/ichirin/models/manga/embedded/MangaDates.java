package me.skiincraft.ichirin.models.manga.embedded;

import me.skiincraft.ichirin.data.manga.MangaDTO;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Embeddable
public class MangaDates {

    @Column(name = "created_date")
    private OffsetDateTime createdDate;
    private LocalDateTime releaseDate;
    @Column(name = "last_update")
    private OffsetDateTime lastUpdate;

    public MangaDates() {
    }

    public MangaDates(MangaDTO dto) {
        // TODO LocalDateTime.now() é temporário
        this.releaseDate = LocalDateTime.now();
    }

    public OffsetDateTime getCreatedTime() {
        return createdDate;
    }

    public void setCreatedTime(OffsetDateTime createdTime) {
        this.createdDate = createdTime;
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

    @PrePersist
    @PreUpdate
    public void update() {
        if (this.createdDate == null)
            this.createdDate = OffsetDateTime.now(Clock.systemUTC());
        this.lastUpdate = OffsetDateTime.now(Clock.systemUTC());
    }
}
