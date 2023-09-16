package pl.library.service;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Title;
import pl.library.entity.dto.title.NewTitleDto;
import pl.library.entity.dto.title.TitleDto;
import pl.library.entity.dto.title.TitlesDto;
import pl.library.mapper.TitleMapper;
import pl.library.repository.TitleRepository;

@Stateless
public class TitleService {

    @EJB
    TitleRepository titleRepository;

    @EJB
    TitleMapper titleMapper;

    public TitleDto addTitle(NewTitleDto dto) {
        return titleMapper.toDto(titleRepository.addTitle(titleMapper.fromDto(dto)));
    }

    public TitleDto findTitleById(Long id) {
        Optional<Title> title = titleRepository.findById(id);
        return titleMapper.toDto(title.isPresent() ? title.get() : null);
    }

    public TitleDto findTitleByName(String name) {
        Optional<Title> title = titleRepository.findByName(name);
        return titleMapper.toDto(title.isPresent() ? title.get() : null);
    }

    public TitlesDto findAll() {
        return titleMapper.toDtoList(titleRepository.findAll());
    }

    public TitleDto updateTitle(Title title) {
        Optional<Title> t = titleRepository.updateTitle(title);
        return titleMapper.toDto(t.isPresent() ? t.get() : null);
    }

    public boolean deleteTitle(Title title) {
        Optional<Title> result = titleRepository.deleteTitle(title);
        return result.isPresent();
    }

}
