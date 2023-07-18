package pl.take.entity;
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
	    private Long volume_id;
	  
	  private String author;
		private LocalDateTime publication_date;
		private LocalDateTime publishing_house;
		 @OneToMany(mappedBy = "rental")
		private List<Rental> rentals;
		 @JoinColumn(name = "title_id")
		private Title title;
		
		
		public Volume(String author, LocalDateTime publication_date, LocalDateTime publishing_house, List<Rental> rentals,Title title) {
			super();
			this.author = author;
			this.publication_date = publication_date;
			this.publishing_house = publishing_house;
			this.rentals = rentals;
			this.title = title;
		}


		@Id
		public Long getId() {
			return volume_id;
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


		public LocalDateTime getPublication_date() {
			return publication_date;
		}


		public void setPublication_date(LocalDateTime publication_date) {
			this.publication_date = publication_date;
		}


		public LocalDateTime getPublishing_house() {
			return publishing_house;
		}


		public void setPublishing_house(LocalDateTime publishing_house) {
			this.publishing_house = publishing_house;
		}
		
		
		public Title getTitle() {
			return title;
		}


		public void setTitle(Title title) {
			this.title = title;
		}
}
