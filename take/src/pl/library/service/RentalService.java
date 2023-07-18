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
import pl.library.repository.RentalRepository;


@Stateless
public class RentalService {
	
    @EJB
   RentalRepository rentalRepository;
    
	 public RentalDto create(NewRentalDto rentalDto) {
	        Rental rental = new Rental();
	       rental.setVolume(rentalDto.getVolume());
	       rental.setRentalDate(rentalDto.getRentalDate());
	       rental.setReader(rental.getReader());
	       rental.setDeliveryDate(rentalDto.getDeliveryDate());
	        Rental createdRental = rentalRepository.addRental(rental);
	        return mapToDto(createdRental);
	    }
	 
	  public Optional<RentalDto> findReaderById(Long id) {
	        Optional<Rental> rental = rentalRepository.findById(id);
	        return rental.map(this::mapToDto);
	    }

	    public RentalsDto findAll() {
	        List<Rental> rentals = rentalRepository.findAll();
	        List<RentalDto> dtos = rentals.stream()
	                .map(this::mapToDto)
	                .collect(Collectors.toList());
	        return new RentalsDto(dtos);
	    }

	    private RentalDto mapToDto(Rental rental) {
	    	RentalDto dto = new RentalDto();
	      dto.setDeliveryDate(rental.getDeliveryDate());
	      dto.setReader(rental.getReader());
	      dto.setRentalDate(rental.getRentalDate());
	      dto.setVolume(rental.getVolume());
	        return dto;
	    }

}
