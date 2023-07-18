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
public class Rental {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long rental_id;
	  private LocalDateTime rental_date;
		private LocalDateTime delivery_date;
		@JoinColumn(name = "reader_id")
		private Reader reader;
		@JoinColumn(name = "volume_id")
		private Volume volume;
		
		public Rental(LocalDateTime rental_date, LocalDateTime delivery_date, Reader reader,Volume volume) {
			super();
			this.rental_date = rental_date;
			this.delivery_date = delivery_date;
			this.reader = reader;
			this.volume = volume;
		}
		
		public Long getId() {
			return rental_id;
		}


		public LocalDateTime getRental_date() {
			return rental_date;
		}


		public void setRental_date(LocalDateTime rental_date) {
			this.rental_date = rental_date;
		}


		public LocalDateTime getDelivery_date() {
			return delivery_date;
		}


		public void setDelivery_date(LocalDateTime delivery_date) {
			this.delivery_date = delivery_date;
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
