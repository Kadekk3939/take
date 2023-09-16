package pl.library.entity.dto.title;

import pl.library.entity.dto.volume.VolumesDto;

public class TitleDto {

	private Long id;
	private String name;
	private VolumesDto volumesDto;


	public TitleDto(Long id, String name, VolumesDto volumesDto) {
		this.id = id;
		this.name = name;
		this.volumesDto = volumesDto;
	}

	public TitleDto() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VolumesDto getVolumesDto() {
		return volumesDto;
	}

	public void setVolumesDto(VolumesDto volumesDto) {
		this.volumesDto = volumesDto;
	}

	
}
