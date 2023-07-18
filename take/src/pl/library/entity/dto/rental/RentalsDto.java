package pl.library.entity.dto.rental;

import java.util.List;

import pl.library.entity.dto.reader.ReaderDto;

public class RentalsDto {


	private List<RentalDto> rentals;
	
	 public RentalsDto(List<RentalDto> rentals) {
		this.rentals = rentals;
	}
}
