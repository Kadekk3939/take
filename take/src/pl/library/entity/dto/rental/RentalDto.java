package pl.library.entity.dto.rental;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;

import pl.library.entity.Reader;
import pl.library.entity.Volume;

public class RentalDto {
	  private Long id;

	    private LocalDateTime rentalDate;

	    private LocalDateTime deliveryDate;

	    private Reader reader;
	    
	    private Volume volume;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getRentalDate() {
			return rentalDate;
		}

		public void setRentalDate(LocalDateTime rentalDate) {
			this.rentalDate = rentalDate;
		}

		public LocalDateTime getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(LocalDateTime deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public Reader getReader() {
			return reader;
		}

		public void setReader(Reader reader) {
			this.reader = reader;
		}

		public Volume getVolume() {
			return volume;
		}

		public void setVolume(Volume volume) {
			this.volume = volume;
		}
	    
	    
	    
}
