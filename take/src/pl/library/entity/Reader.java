package pl.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readerId;
    
    private String name;

	private String surname;

	@Column(nullable = false, unique = true)
	private String login;

	private String password;

	@OneToMany(mappedBy = "reader")
	private List<Rental> rentals;
	
	public Reader(String name, String surname, String login, String password, List<Rental> rentals) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.rentals = rentals;
	}

    public Long getReaderId() {
        return readerId;
    }

	public List<Rental> getRentals() {
		return rentals;
	}


	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
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
}