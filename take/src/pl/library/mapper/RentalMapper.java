package pl.library.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Rental;
import pl.library.entity.Volume;
import pl.library.entity.Reader;
import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.rental.NewRentalDto;
import pl.library.entity.dto.rental.RentalDto;
import pl.library.entity.dto.rental.RentalsDto;
import pl.library.entity.dto.title.TitleDto;
import pl.library.entity.dto.volume.VolumeDto;
import pl.library.repository.ReaderRepository;
import pl.library.repository.VolumeRepository;

@Stateless
public class RentalMapper {

    @EJB
    ReaderRepository readerRepository;

    @EJB
    VolumeRepository volumeRepository;

    public Rental fromDto(NewRentalDto dto) {
        if (dto == null) return null;
        Rental rental = new Rental();
        Optional<Reader> reader = readerRepository.findById(dto.getReaderDto().getId());
        Optional<Volume> volume = volumeRepository.findById(dto.getVolumeDto().getId());
        rental.setRentalDate(LocalDateTime.now());
        rental.setReader(reader.isPresent() ? reader.get() : null);
        rental.setVolume(volume.isPresent() ? volume.get() : null);

        return rental;
        
    }

    public RentalDto toDto(Rental rental) {
        if (rental == null) return null;
        RentalDto dto = new RentalDto();
        dto.setDeliveryDate(rental.getDeliveryDate());
        dto.setRentalDate(rental.getRentalDate());

        ReaderDto reader = new ReaderDto();
        reader.setId(rental.getReader().getReaderId());
        reader.setName(rental.getReader().getName());
        reader.setSurname(rental.getReader().getSurname());
        reader.setLogin(rental.getReader().getLogin());
        dto.setReaderDto(reader);

        VolumeDto volume = new VolumeDto();
        TitleDto title = new TitleDto();
        title.setId(rental.getVolume().getTitle().getTitleId());
        title.setName(rental.getVolume().getTitle().getName());
        volume.setTitleDto(title);
        volume.setAuthor(rental.getVolume().getAuthor());
        volume.setPublicationDate(rental.getVolume().getPublicationDate().toString());
        volume.setPublishingHouse(rental.getVolume().getPublishingHouse());
        dto.setVolumeDto(volume);

        return dto;
    }

    public RentalsDto toDtoList(List<Rental> rentals) {
        if (rentals == null) return null;
        RentalsDto rentalsDto = new RentalsDto();
        rentalsDto.setRentals(rentals.stream().map(t -> toDto(t)).collect(Collectors.toList()));
        return rentalsDto;
    }
}
