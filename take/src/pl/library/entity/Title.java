package pl.library.entity;

import javax.persistence.Column;
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

	@Column(nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "title")
	private List<Volume> volumes;
	

	public Title(String name, List<Volume> volumes) {
		this.name = name;
		this.volumes = volumes;
	}

	public Title(){}
	
	
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