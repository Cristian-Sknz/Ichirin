package me.skiincraft.ichirin.data;

import javax.validation.constraints.NotBlank;

public class UserCommentaryDTO {

    private long mangaId;

    @NotBlank(message = "validation.commentary.content")
    private String content;

    public UserCommentaryDTO() {
    }

    public UserCommentaryDTO(String content) {
        this.content = content;
    }

    public long getMangaId() {
        return mangaId;
    }

    public UserCommentaryDTO setMangaId(long mangaId) {
        this.mangaId = mangaId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
