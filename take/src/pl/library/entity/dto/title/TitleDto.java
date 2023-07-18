package pl.library.entity.dto.title;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pl.library.entity.Volume;

public class TitleDto {

	    private Long id;
	  private String name;

		private List<Volume> volumes;

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

		public List<Volume> getVolumes() {
			return volumes;
		}

		public void setVolumes(List<Volume> volumes) {
			this.volumes = volumes;
		}
}
