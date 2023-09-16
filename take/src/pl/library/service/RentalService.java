package pl.library.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Reader;
import pl.library.entity.Rental;
import pl.library.entity.Volume;
import pl.library.entity.dto.reader.ReadersDto;
import pl.library.entity.dto.rental.NewRentalDto;
import pl.library.entity.dto.rental.RentalDto;
import pl.library.entity.dto.rental.RentalsDto;
import pl.library.mapper.RentalMapper;
import pl.library.repository.ReaderRepository;
import pl.library.repository.RentalRepository;
import pl.library.repository.VolumeRepository;


@Stateless
public class RentalService {
	
    @EJB
   	RentalRepository rentalRepository;

	@EJB
	RentalMapper rentalMapper;

	@EJB
	ReaderRepository readerRepository;

	@EJB
	VolumeRepository volumeRepository;

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

	public RentalDto deliverRental(Long readerId, Long volumeId) {
		Optional<Reader> reader = readerRepository.findById(readerId);
		Optional<Volume> volume = volumeRepository.findById(volumeId);

		if (!reader.isPresent() || !volume.isPresent()) {
			return null;
		}

		Optional<Rental> found = rentalRepository.findRentalByReaderAndVolume(readerId, volumeId);

		if (!found.isPresent()) {
			return null;
		}

		Rental rental = found.get();
		rental.setDeliveryDate(LocalDateTime.now());

		Optional<Rental> result = rentalRepository.updateRental(rental);
		
		return rentalMapper.toDto(result.isPresent() ? result.get() : null);
	}

}
