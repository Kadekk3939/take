package pl.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    private LocalDateTime rentalDate;

    private LocalDateTime deliveryDate;

    @JoinColumn(name = "readerId")
    private Reader reader;
    
    @JoinColumn(name = "volumeId")
    private Volume volume;
    
    public Rental(LocalDateTime rentalDate, LocalDateTime deliveryDate, Reader reader,Volume volume) {
        super();
        this.rentalDate = rentalDate;
        this.deliveryDate = deliveryDate;
        this.reader = reader;
        this.volume = volume;
    }
    
    public Long getRentalId() {
        return rentalId;
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