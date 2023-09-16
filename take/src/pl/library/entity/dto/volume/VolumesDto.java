package pl.library.entity.dto.volume;

import java.util.ArrayList;
import java.util.List;

public class VolumesDto {
	private List<VolumeDto> volumes = new ArrayList<>();

	public VolumesDto(List<VolumeDto> volumes) {
		this.volumes = volumes;
	}

	public VolumesDto() {
	}

	public List<VolumeDto> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<VolumeDto> volumes) {
		this.volumes = volumes;
	}

}
