package pl.library.entity.dto.volume;

import java.time.LocalDateTime;

import pl.library.entity.dto.rental.RentalsDto;
import pl.library.entity.dto.title.TitleDto;

public class VolumeDto {
	
	private Long id;
	private String author;
	private LocalDateTime publicationDate;
	private LocalDateTime publishingHouse;
	private RentalsDto rentalsDto;
	private TitleDto titleDto;

	public VolumeDto() {
	}

	public VolumeDto(Long id, String author, LocalDateTime publicationDate, LocalDateTime publishingHouse,
			RentalsDto rentalsDto, TitleDto titleDto) {
		this.id = id;
		this.author = author;
		this.publicationDate = publicationDate;
		this.publishingHouse = publishingHouse;
		this.rentalsDto = rentalsDto;
		this.titleDto = titleDto;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public RentalsDto getRentals() {
		return rentalsDto;
	}
	public void setRentals(RentalsDto rentalsDto) {
		this.rentalsDto = rentalsDto;
	}
	public TitleDto getTitleDto() {
		return titleDto;
	}
	public void setTitleDto(TitleDto titleDto) {
		this.titleDto = titleDto;
	}
		
}
