package pl.library.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.library.entity.Volume;
import pl.library.entity.dto.volume.NewVolumeDto;
import pl.library.entity.dto.volume.VolumeDto;
import pl.library.entity.dto.volume.VolumesDto;

@Path("/volume")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface VolumeControllerREST {

    @POST
    VolumeDto addVolume(NewVolumeDto dto);

    @GET
    VolumesDto getAllVolumes();

    @GET
    @Path("/{id}")
    VolumeDto getVolumeById(@PathParam("id") Long id);
    
    @PUT
    VolumeDto updateVolume(Volume volume);
}