package pl.library.entity.dto.volume;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import pl.library.entity.Rental;
import pl.library.entity.Title;

public class VolumeDto {
	
	    private Long id;
	    private String author;
		private LocalDateTime publicationDate;
		private LocalDateTime publishingHouse;
		private List<Rental> rentals;
		private Title title;
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
		public List<Rental> getRentals() {
			return rentals;
		}
		public void setRentals(List<Rental> rentals) {
			this.rentals = rentals;
		}
		public Title getTitle() {
			return title;
		}
		public void setTitle(Title title) {
			this.title = title;
		}
		
		
}
