package me.skiincraft.ichirin.models.user;

import me.skiincraft.ichirin.models.user.enums.ReadingStyle;

import javax.persistence.Embeddable;

@Embeddable
public class UserConfiguration {

    private ReadingStyle readingStyle;
    private int imagesPerPage;

    public UserConfiguration() {
        this.readingStyle = ReadingStyle.DEFAULT;
        this.imagesPerPage = 1;
    }

    public ReadingStyle getReadingStyle() {
        return readingStyle;
    }

    public void setReadingStyle(ReadingStyle readingStyle) {
        this.readingStyle = readingStyle;
    }

    public int getImagesPerPage() {
        return imagesPerPage;
    }

    public void setImagesPerPage(int imagesPerPage) {
        this.imagesPerPage = imagesPerPage;
    }
}
