package pl.library.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.library.entity.Reader;
import pl.library.entity.dto.reader.NewReaderDto;
import pl.library.entity.dto.reader.ReaderDto;
import pl.library.entity.dto.reader.ReadersDto;
import pl.library.entity.dto.title.NewTitleDto;
import pl.library.entity.dto.title.TitleDto;

@Path("/reader")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface ReaderControllerREST {

    @POST
    ReaderDto addReader(NewReaderDto dto);

    @GET
    ReadersDto getAllReaders();

    @GET
    @Path("/{id}")
    ReaderDto getReaderById(@PathParam("id") Long id);

    @PUT
    ReaderDto updateReader(Reader reader);

    @DELETE
    boolean deleteReader(Reader reader);
    
}