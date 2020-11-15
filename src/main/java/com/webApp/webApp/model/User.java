package com.webApp.webApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "ID_KEY")
	private Integer idKey;
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_LAST_NAME")
	private String userLastName;
	@Column(name = "USER_NIF")
	private String userNif;
	@Column(name = "REGISTRATION_DATE")
	private String registrationDate;

	public User(){

	}

	public User(Integer idKey, Integer userId, String userName, String userLastName, String userNif, String registrationDate) {
		this.idKey = idKey;
		this.userId = userId;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userNif = userNif;
		this.registrationDate = registrationDate;
	}

	public Integer getIdKey() {
		return idKey;
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

