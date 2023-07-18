package pl.library.entity.dto.reader;

import java.util.List;

import javax.persistence.OneToMany;

import pl.library.entity.Rental;

public class ReaderDto {
	 	private Long id;
	    private String name;
		private String surname;
		private List<Rental> rentals;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public List<Rental> getRentals() {
			return rentals;
		}
		public void setRentals(List<Rental> rentals) {
			this.rentals = rentals;
		}
		
		
}
