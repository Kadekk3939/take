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
}
