package pl.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Title {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long titleId;
	  private String name;
	  @OneToMany(mappedBy = "title")
		private List<Volume> volumes;
		
		public Title(String name, List<Volume> volumes) {
			super();
			this.name = name;
			this.volumes = volumes;
		}

		public Long getTitleId() {
			return titleId;
		}

		public List<Volume> getVolumes() {
			return volumes;
		}

		public void setVolumes(List<Volume> volumes) {
			this.volumes = volumes;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}