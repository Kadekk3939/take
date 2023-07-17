package eu.myszojelenie.controller;

import eu.myszojelenie.controller.dto.internship.InternshipDto;
import eu.myszojelenie.controller.dto.internship.InternshipsDto;
import eu.myszojelenie.controller.dto.internship.NewInternshipDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/internship")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface InternshipController {

    @POST
    InternshipDto create(NewInternshipDto internship);

    @GET
    @Path("/{id}")
    InternshipDto getById(@PathParam("id") Long id);

    @GET
    InternshipsDto getAll();

}
