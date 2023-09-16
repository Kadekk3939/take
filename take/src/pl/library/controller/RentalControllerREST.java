package pl.library.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.library.entity.Rental;
import pl.library.entity.dto.rental.NewRentalDto;
import pl.library.entity.dto.rental.RentalDto;
import pl.library.entity.dto.rental.RentalsDto;

@Path("/rental")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface RentalControllerREST {

    @POST
    RentalDto addRental(NewRentalDto dto);

    @GET
    RentalsDto getAllRentals();

    @GET
    @Path("/{id}")
    RentalDto getRentalById(@PathParam("id") Long id);

    @PUT
    @Path("/return/{readerId}/{volumeId}")
    RentalDto deliverRental(@PathParam("readerId") Long readerId, @PathParam("volumeId") Long volumeId);
    
}