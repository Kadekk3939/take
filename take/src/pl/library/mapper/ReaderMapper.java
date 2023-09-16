package pl.library.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import pl.library.entity.Reader;
import pl.library.entity.dto.reader.NewReaderDto;
import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.reader.ReadersDto;

@Stateless
public class ReaderMapper {
    
    public Reader fromDto(NewReaderDto dto) {
        if (dto == null) return null;
        Reader reader = new Reader();
        reader.setLogin(dto.getLogin());
        reader.setPassword(dto.getPassword());
        reader.setName(dto.getName());
        reader.setSurname(dto.getSurname());
        reader.setRentals(new ArrayList<>());
        return reader;
    }

    public ReaderDto toDto(Reader reader) {
        if (reader == null) return null;
        ReaderDto dto = new ReaderDto();
        dto.setId(reader.getReaderId());
        dto.setLogin(reader.getLogin());
        dto.setName(reader.getName());
        dto.setSurname(reader.getSurname());

        //TODO
        return null;
    }

    public ReadersDto toDtoList(List<Reader> readers) {
        if (readers == null) return null;
        ReadersDto readersDto = new ReadersDto();
        readersDto.setReaders(readers.stream().map(t -> toDto(t)).collect(Collectors.toList()));
        return readersDto;
    }
}
