package pl.library.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Title;
import pl.library.entity.dto.title.NewTitleDto;
import pl.library.entity.dto.title.TitleDto;
import pl.library.entity.dto.title.TitlesDto;

@Stateless
public class TitleMapper {

    @EJB
    VolumeMapper volumeMapper;

    public Title fromDto(NewTitleDto dto) {
        if (dto == null) return null;
        Title title = new Title();
        title.setName(dto.getName());
        title.setVolumes(new ArrayList<>());
        return title;
    }

    public TitleDto toDto(Title title) {
        if (title == null) return null;
        TitleDto dto = new TitleDto();
        dto.setId(title.getTitleId());
        dto.setName(title.getName());
        dto.setVolumesDto(null); //TODO
        
        return dto;
    }

    public TitlesDto toDtoList(List<Title> titles) {
        if (titles == null) return null;
        TitlesDto titlesDto = new TitlesDto();
        titlesDto.setTitles(titles.stream().map(t -> toDto(t)).collect(Collectors.toList()));
        return titlesDto;
    }
    
}
