package pl.library.entity.dto.reader;

import java.util.ArrayList;
import java.util.List;

public class ReadersDto {
	private List<ReaderDto> readers = new ArrayList<>();

	public ReadersDto(List<ReaderDto> readers) {
		this.readers = readers;
	}

	public ReadersDto() {

	}

	public List<ReaderDto> getReaders() {
		return readers;
	}


	public void setReaders(List<ReaderDto> readers) {
		this.readers = readers;
	}

}
