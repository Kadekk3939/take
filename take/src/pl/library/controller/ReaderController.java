package pl.library.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Reader;
import pl.library.entity.dto.reader.NewReaderDto;
import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.reader.ReadersDto;
import pl.library.service.ReaderService;

@Stateless
public class ReaderController implements ReaderControllerREST {

    @EJB
    ReaderService readerService;

    @Override
    public ReaderDto addReader(NewReaderDto dto) {
        return readerService.addReader(dto);
    }

    @Override
    public ReadersDto getAllReaders() {
        return readerService.findAll();
    }

    @Override
    public ReaderDto getReaderById(Long id) {
        return readerService.findReaderById(id);
    }

    @Override
    public ReaderDto updateReader(Reader reader) {
        return readerService.updateReader(reader);
    }

    @Override
    public boolean deleteReader(Reader reader) {
        return readerService.deleteReader(reader);
    }
    
}
