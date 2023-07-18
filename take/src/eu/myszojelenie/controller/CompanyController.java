package eu.myszojelenie.controller;

import eu.myszojelenie.controller.dto.company.CompanyCollectionDto;
import eu.myszojelenie.controller.dto.company.CompanyDto;
import eu.myszojelenie.controller.dto.company.NewCompanyDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/company")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface CompanyController {

    @GET
    @Path("/{id}")
    CompanyDto getCompany(@PathParam("id") Long id);

    @GET
    CompanyCollectionDto getAllCompanies();

    @POST
    CompanyDto createCompany(NewCompanyDto dto);
}
