package pl.library.entity.dto.volume;

import java.time.LocalDateTime;

import pl.library.entity.dto.title.TitleDto;

public class NewVolumeDto {
    
    private String author;
    private LocalDateTime publicationDate;
    private LocalDateTime publishingHouse;
    private TitleDto titleDto;

    public NewVolumeDto() {
    }

    public NewVolumeDto(String author, LocalDateTime publicationDate, LocalDateTime publishingHouse,
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

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDateTime getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(LocalDateTime publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public TitleDto getTitleDto() {
        return titleDto;
    }

    public void setTitleDto(TitleDto titleDto) {
        this.titleDto = titleDto;
    }
}
