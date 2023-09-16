package pl.library.entity.dto.rental;

import java.util.ArrayList;
import java.util.List;

public class RentalsDto {
	private List<RentalDto> rentals = new ArrayList<>();
	
	public RentalsDto(List<RentalDto> rentals) {
		this.rentals = rentals;
	}

	public RentalsDto() {
	}

	public List<RentalDto> getRentals() {
		return rentals;
	}

	public void setRentals(List<RentalDto> rentals) {
		this.rentals = rentals;
	}

}
