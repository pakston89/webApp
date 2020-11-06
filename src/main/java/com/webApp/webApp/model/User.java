package com.webApp.webApp.model;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {

	@Id
	@GeneratedValue
	private Integer idKey;
	private Integer userId;
	private String userName;
	private String userLastName;
	private String userNif;
	private String registrationDate;

	public User(){
		super();
	}

	public User(Integer userId, String userName, String userLastName, String userNif, String registrationDate) {

		this.userId = userId;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userNif = userNif;
		this.registrationDate = registrationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserNif() {
		return userNif;
	}

	public void setUserNif(String userNif) {
		this.userNif = userNif;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
}

