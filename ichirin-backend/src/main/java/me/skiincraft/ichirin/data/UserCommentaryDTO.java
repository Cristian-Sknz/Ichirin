package me.skiincraft.ichirin.data;

import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
public class UserCommentaryDTO {

    @NotBlank(message = "validation.commentary.content")
    private String content;

    public UserCommentaryDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
