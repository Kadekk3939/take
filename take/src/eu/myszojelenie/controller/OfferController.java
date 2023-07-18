package eu.myszojelenie.controller;


import eu.myszojelenie.controller.dto.offer.NewOfferDto;
import eu.myszojelenie.controller.dto.offer.OfferDto;
import eu.myszojelenie.controller.dto.offer.OffersDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/offer")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface OfferController {

    @POST
    OfferDto createOffer(NewOfferDto offerDto);

    @GET
    @Path("/{id}")
    OfferDto getOfferById(@PathParam("id") Long offerId);

    @GET
    OffersDto getOffers(@QueryParam("withRemoved") Boolean withRemoved);

    @DELETE
    @Path("/{id}")
    void inactivateOffer(@PathParam("id") Long offerId);

    @PUT
    @Path("/{id}")
    OfferDto activateOffer(@PathParam("id") Long offerId);

}
