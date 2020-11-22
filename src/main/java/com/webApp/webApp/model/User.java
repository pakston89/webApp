package com.webApp.webApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "nif")
	private String nif;
	@Column(name = "registration_date")
	private LocalDate registrationDate;

	public User(){

	}

	public User(Integer id, String name, String lastName, String nif, LocalDate registrationDate) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.nif = nif;
		this.registrationDate = registrationDate;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}

