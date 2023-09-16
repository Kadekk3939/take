package pl.library.service;



import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Reader;
import pl.library.entity.dto.reader.NewReaderDto;
import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.reader.ReadersDto;
import pl.library.mapper.ReaderMapper;
import pl.library.repository.ReaderRepository;

@Stateless
public class ReaderService {

    @EJB
    ReaderRepository readerRepository;

	@EJB
	ReaderMapper readerMapper;
    
	public ReaderDto addReader(NewReaderDto readerDto) {
		return readerMapper.toDto(readerRepository.addReader(readerMapper.fromDto(readerDto)));
	}
	
	public ReaderDto findReaderById(Long id) {
		Optional<Reader> reader = readerRepository.findById(id);
		return readerMapper.toDto(reader.isPresent() ? reader.get() : null);
	}

	public ReadersDto findAll() {
		return readerMapper.toDtoList(readerRepository.findAll());
	}

	public ReaderDto updateReader(Reader reader) {
		Optional<Reader> r = readerRepository.findById(reader.getReaderId());
		return readerMapper.toDto(r.isPresent() ? r.get() : null);
	}

	public boolean deleteReader(Reader reader) {
		Optional<Reader> result = readerRepository.deleteReader(reader);
		return result.isPresent();
	}
}
