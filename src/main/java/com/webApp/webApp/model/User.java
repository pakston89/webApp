package com.webApp.webApp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="users")
@Getter @Setter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nif")
	private String nif;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "secret_key")
	private String secretKey;

	@Column(name = "salt")
	private String salt;

	@Column(name = "registration_date")
	private LocalDate registrationDate;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "roles")
	private String roles;

	public User() {

	}

	public User(Integer id, String firstName, String lastName, String nif, String cardNumber, LocalDate registrationDate, String userName, String password, Boolean active, String roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nif = nif;
		this.cardNumber = cardNumber;
		this.registrationDate = registrationDate;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
}

