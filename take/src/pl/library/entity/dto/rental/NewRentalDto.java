package pl.library.entity.dto.rental;

import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.volume.VolumeDto;

public class NewRentalDto {

	private ReaderDto readerDto;
	private VolumeDto volumeDto;
	
	public NewRentalDto(ReaderDto readerDto, VolumeDto volumeDto) {
		this.readerDto = readerDto;
		this.volumeDto = volumeDto;
	}

	public NewRentalDto() {
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
