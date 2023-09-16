package pl.library.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pl.library.entity.Title;
import pl.library.entity.dto.title.NewTitleDto;
import pl.library.entity.dto.title.TitleDto;
import pl.library.entity.dto.title.TitlesDto;
import pl.library.service.TitleService;

@Stateless
public class TitleController implements TitleControllerREST {

    @EJB
    TitleService titleService;

    @Override
    public TitleDto addTitle(NewTitleDto dto) {
        return titleService.addTitle(dto);
    }

    @Override
    public TitlesDto getAllTitles() {
        return titleService.findAll();
    }

    @Override
    public TitleDto getTitleById(Long id) {
        return titleService.findTitleById(id);
    }

    @Override
    public TitleDto updateTitle(Title title) {
        return titleService.updateTitle(title);
    }

    @Override
    public boolean deleteTitle(Title title) {
        return titleService.deleteTitle(title);
    }
    
}
