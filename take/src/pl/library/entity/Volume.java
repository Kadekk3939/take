package pl.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Volume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long volumeId;
	
	private String author;

	private LocalDateTime publicationDate;

	private LocalDateTime publishingHouse;

	@OneToMany(mappedBy = "rental")
	private List<Rental> rentals;

	@JoinColumn(name = "title_id")
	private Title title;
	

	public Volume(String author, LocalDateTime publicationDate, LocalDateTime publishingHouse, List<Rental> rentals,Title title) {
		this.author = author;
		this.publicationDate = publicationDate;
		this.publishingHouse = publishingHouse;
		this.rentals = rentals;
		this.title = title;
	}

	public Long getVolumeId() {
		return volumeId;
	}

	public List<Rental> getRentals() {
		return rentals;
	}


	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
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
	
	
	public Title getTitle() {
		return title;
	}


	public void setTitle(Title title) {
		this.title = title;
	}
}