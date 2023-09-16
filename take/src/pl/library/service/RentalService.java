package pl.library.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Rental;
import pl.library.entity.dto.reader.ReadersDto;
import pl.library.entity.dto.rental.NewRentalDto;
import pl.library.entity.dto.rental.RentalDto;
import pl.library.entity.dto.rental.RentalsDto;
import pl.library.mapper.RentalMapper;
import pl.library.repository.RentalRepository;


@Stateless
public class RentalService {
	
    @EJB
   	RentalRepository rentalRepository;

	@EJB
	RentalMapper rentalMapper;

	public RentalDto addRental(NewRentalDto rentalDto) {
		return rentalMapper.toDto(rentalRepository.addRental(rentalMapper.fromDto(rentalDto)));
	}
	
	public RentalDto findRentalById(Long id) {
		Optional<Rental> rental = rentalRepository.findById(id);
		return rentalMapper.toDto(rental.isPresent() ? rental.get() : null);
	}

	public RentalsDto findAll() {
		return rentalMapper.toDtoList(rentalRepository.findAll());
	}

}
