package pl.kurs.library;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Rentals")
@XmlRootElement
public class Rental implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@XmlAttribute
	int id;
	
	@XmlAttribute
	@Column(nullable=false)
	Reader reader;
	
	@XmlAttribute
	@Column(nullable=false)
	Volume volume;
	
	@XmlAttribute
	@Column(nullable=false)
	LocalDateTime rentalDate;
	
	@XmlAttribute
	@Column(nullable=true)
	LocalDateTime deliveryDate;
	
	public Rental(int id, LocalDateTime rentalDate, LocalDateTime deliveryDate, Reader reader, Volume volume) {
		super();
		this.id = id;
		this.rentalDate = rentalDate;
		this.deliveryDate = deliveryDate;
		this.reader = reader;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
