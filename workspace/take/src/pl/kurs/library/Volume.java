package pl.kurs.library;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Volumes")
@XmlRootElement
public class Volume implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@XmlAttribute
	int id;
	
	@XmlAttribute
	@Column(nullable=false)
	Title title;
	
	@XmlAttribute
	@Column(nullable=false)
	String author;
	
	@XmlAttribute
	@Column(nullable=false)
	LocalDate publicationDate;
	
	@XmlAttribute
	@Column(nullable=false)
	String publishingHouse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	
	
}
