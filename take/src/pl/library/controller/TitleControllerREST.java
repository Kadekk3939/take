package pl.library.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.library.entity.Title;
import pl.library.entity.dto.title.NewTitleDto;
import pl.library.entity.dto.title.TitleDto;
import pl.library.entity.dto.title.TitlesDto;

@Path("/title")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface TitleControllerREST {

    @POST
    TitleDto addTitle(NewTitleDto dto);

    @GET
    TitlesDto getAllTitles();

    @GET
    @Path("/{id}")
    TitleDto getTitleById(@PathParam("id") Long id);

    @PUT
    TitleDto updateTitle(Title title);
}