package com.webApp.webApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="users")
@Getter @Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Setter(AccessLevel.NONE)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "nif")
	private String nif;
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	@Column(name = "user_name")
	@JsonIgnore
	private String userName;
	@Column(name = "password")
	@JsonIgnore
	private String password;
	@Column(name = "active")
	@JsonIgnore
	private Boolean active;
	@Column(name = "roles")
	@JsonIgnore
	@Setter(AccessLevel.NONE)
	private String roles;

	public User(){

	}

	public User(Integer id, String firstName, String lastName, String nif, LocalDate registrationDate, String userName, String password, Boolean active, String roles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nif = nif;
		this.registrationDate = registrationDate;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
}

