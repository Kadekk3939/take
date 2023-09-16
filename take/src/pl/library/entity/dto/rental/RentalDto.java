package pl.library.entity.dto.rental;

import java.time.LocalDateTime;

import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.volume.VolumeDto;

public class RentalDto {

	private LocalDateTime rentalDate;
	private LocalDateTime deliveryDate;
	private ReaderDto readerDto;
	private VolumeDto volumeDto;


	public RentalDto(LocalDateTime rentalDate, LocalDateTime deliveryDate, ReaderDto readerDto, VolumeDto volumeDto) {
		this.rentalDate = rentalDate;
		this.deliveryDate = deliveryDate;
		this.readerDto = readerDto;
		this.volumeDto = volumeDto;
	}

	public RentalDto() {
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
	public ReaderDto getReaderDto() {
		return readerDto;
	}
	public void setReaderDto(ReaderDto readerDto) {
		this.readerDto = readerDto;
	}
	public VolumeDto getVolumeDto() {
		return volumeDto;
	}
	public void setVolumeDto(VolumeDto volumeDto) {
		this.volumeDto = volumeDto;
	}    
	    
}
