package pl.library.service;

import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Volume;
import pl.library.entity.dto.volume.NewVolumeDto;
import pl.library.entity.dto.volume.VolumeDto;
import pl.library.entity.dto.volume.VolumesDto;
import pl.library.mapper.VolumeMapper;
import pl.library.repository.VolumeRepository;

@Stateless
public class VolumeService {

    @EJB
    VolumeRepository volumeRepository;

    @EJB
    VolumeMapper volumeMapper;

    public VolumeDto addVolume(NewVolumeDto dto) {
        return volumeMapper.toDto(volumeRepository.addVolume(volumeMapper.fromDto(dto)));
    }

    public VolumeDto findVolumeById(Long id) {
        Optional<Volume> volume = volumeRepository.findById(id);
        return volumeMapper.toDto(volume.isPresent() ? volume.get() : null);
    }

    public VolumesDto findAll() {
        return volumeMapper.toDtoList(volumeRepository.findAll());
    }

    public VolumeDto updateVolume(Volume volume) {
        Optional<Volume> v = volumeRepository.updateVolume(volume);
        return volumeMapper.toDto(v.isPresent() ? v.get() : null);
    }

    public boolean deleteVolume(Volume volume) {
        Optional<Volume> result = volumeRepository.deleteVolume(volume);
        return result.isPresent();
    }

    public boolean deleteVolumeById(Long id) {
        Optional<Volume> result = volumeRepository.deleteVolumeById(id);
        return result.isPresent();
    }
    
    
}
