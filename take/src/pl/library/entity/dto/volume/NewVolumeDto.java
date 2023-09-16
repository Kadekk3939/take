package pl.library.entity.dto.volume;

import pl.library.entity.dto.title.TitleDto;

public class NewVolumeDto {
    
    private String author;
    private String publicationDate;
    private String publishingHouse;
    private TitleDto titleDto;

    public NewVolumeDto() {
    }

    public NewVolumeDto(String author, String publicationDate, String publishingHouse,
            TitleDto titleDto) {
        this.author = author;
        this.publicationDate = publicationDate;
        this.publishingHouse = publishingHouse;
        this.titleDto = titleDto;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public TitleDto getTitleDto() {
        return titleDto;
    }

    public void setTitleDto(TitleDto titleDto) {
        this.titleDto = titleDto;
    }
}
