package pl.library.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Title;
import pl.library.entity.Volume;
import pl.library.entity.dto.title.TitleDto;
import pl.library.entity.dto.volume.NewVolumeDto;
import pl.library.entity.dto.volume.VolumeDto;
import pl.library.entity.dto.volume.VolumesDto;
import pl.library.repository.TitleRepository;

@Stateless
public class VolumeMapper {

    @EJB
    TitleRepository titleRepository;

    public Volume fromDto(NewVolumeDto dto) {
        if (dto == null) return null;
        Volume volume = new Volume();
        volume.setAuthor(dto.getAuthor());
        volume.setPublicationDate(LocalDateTime.parse(dto.getPublicationDate()));
        volume.setPublishingHouse(dto.getPublishingHouse());
        volume.setRentals(new ArrayList<>());
        Optional<Title> title = titleRepository.findByName(dto.getTitleDto().getName());
        volume.setTitle(title.isPresent() ? title.get() : null);
        return volume;
    }

    public VolumeDto toDto(Volume volume) {
        if (volume == null) return null;
        VolumeDto dto = new VolumeDto();
        dto.setAuthor(volume.getAuthor());
        dto.setPublicationDate(volume.getPublicationDate().toString());
        dto.setPublishingHouse(volume.getPublishingHouse());
        dto.setId(volume.getVolumeId());
        TitleDto title = new TitleDto();
        title.setId(volume.getTitle().getTitleId());
        title.setName(volume.getTitle().getName());
        dto.setTitleDto(title);
        
        return dto;
    }

    public VolumesDto toDtoList(List<Volume> volumes) {
        if (volumes == null) return null;
        VolumesDto volumesDto = new VolumesDto();
        volumesDto.setVolumes(volumes.stream().map(t -> toDto(t)).collect(Collectors.toList()));
        return volumesDto;
    }
    
}
