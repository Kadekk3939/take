package pl.library.entity.dto.title;

import java.util.ArrayList;
import java.util.List;

public class TitlesDto {
	private List<TitleDto> titles = new ArrayList<>();

	public TitlesDto(List<TitleDto> titles) {
		this.titles = titles;
	}

	public TitlesDto() {
	}

	public List<TitleDto> getTitles() {
		return titles;
	}

	public void setTitles(List<TitleDto> titles) {
		this.titles = titles;
	}
	
}
