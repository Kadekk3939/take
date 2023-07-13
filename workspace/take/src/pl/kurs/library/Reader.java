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
@Table(name="Readers")
@XmlRootElement
public class Reader implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@XmlAttribute
	int id;
	
	@XmlAttribute
	@Column(nullable=false)
	String name;
	
	@XmlAttribute
	@Column(nullable=false)
	String surname;
	
	@XmlAttribute
	@Column(nullable=false)
	String login;
	
	@XmlAttribute
	@Column(nullable=false)
	String password;
	
	@XmlAttribute
	List<Rental> rentals = new ArrayList<Rental>();
	
	public Reader(int id, String name, String surname, String login, String password, List<Rental> rentals) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.rentals = rentals;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
}
