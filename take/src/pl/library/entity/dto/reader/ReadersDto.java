package pl.library.entity.dto.reader;

import java.util.List;



public class ReadersDto {
	 private List<ReaderDto> readers;

	public List<ReaderDto> getReaders() {
		return readers;
	}

	public void setReaders(List<ReaderDto> readers) {
		this.readers = readers;
	}

	public ReadersDto(List<ReaderDto> readers) {
		this.readers = readers;
	}

	 
	 
}
