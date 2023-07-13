package pl.kurs.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Titles")
@XmlRootElement
public class Title implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@XmlAttribute
	int id;
	
	@XmlAttribute
	@Column(nullable=false)
	String name;

	@XmlAttribute
	List<Volume> volumes = new ArrayList<Volume>();
	
	public Title(int id, String name, List<Volume> volumes) {
		super();
		this.id = id;
		this.name = name;
		this.volumes = volumes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

