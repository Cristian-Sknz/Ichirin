package me.skiincraft.ichirin.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.skiincraft.ichirin.entity.user.enums.ReadingStyle;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@ToString
public class UserConfiguration {

    private ReadingStyle readingStyle;
    private int imagesPerPage;

    public UserConfiguration() {
        this.readingStyle = ReadingStyle.DEFAULT;
        this.imagesPerPage = 1;
    }
}
