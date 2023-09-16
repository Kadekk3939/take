package pl.library.entity.dto.reader;

import pl.library.entity.dto.rental.RentalsDto;

public class ReaderDto {

	private Long id;
	private String name;
	private String surname;
	private String login;
	private RentalsDto rentalsDto;

	
	public ReaderDto(Long id, String name, String surname, String login, RentalsDto rentalsDto) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.rentalsDto = rentalsDto;
	}

	public ReaderDto() {
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
	public RentalsDto getRentalsDto() {
		return rentalsDto;
	}
	public void setRentalsDto(RentalsDto rentalsDto) {
		this.rentalsDto = rentalsDto;
	}
}
