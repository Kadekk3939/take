package pl.library.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Rental;
import pl.library.entity.dto.rental.NewRentalDto;
import pl.library.entity.dto.rental.RentalDto;
import pl.library.entity.dto.rental.RentalsDto;
import pl.library.service.RentalService;

@Stateless
public class RentalController implements RentalControllerREST {


    @EJB
    RentalService rentalService;

    @Override
    public RentalDto addRental(NewRentalDto dto) {
        return rentalService.addRental(dto);
    }

    @Override
    public RentalsDto getAllRentals() {
        return rentalService.findAll();
    }

    @Override
    public RentalDto getRentalById(Long id) {
        return rentalService.findRentalById(id);
    }

    @Override
    public RentalDto deliverRental(Long readerId, Long volumeId) {
        return rentalService.deliverRental(readerId, volumeId);
    }

    
    
}
