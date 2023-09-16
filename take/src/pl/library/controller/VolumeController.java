package pl.library.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Volume;
import pl.library.entity.dto.volume.NewVolumeDto;
import pl.library.entity.dto.volume.VolumeDto;
import pl.library.entity.dto.volume.VolumesDto;
import pl.library.service.VolumeService;

@Stateless
public class VolumeController implements VolumeControllerREST {

    @EJB
    VolumeService volumeService;

    @Override
    public VolumeDto addVolume(NewVolumeDto dto) {
        return volumeService.addVolume(dto);
    }

    @Override
    public VolumesDto getAllVolumes() {
        return volumeService.findAll();
    }

    @Override
    public VolumeDto getVolumeById(Long id) {
        return volumeService.findVolumeById(id);
    }

    @Override
    public VolumeDto updateVolume(Volume volume) {
        return volumeService.updateVolume(volume);
    }

    
    
}
