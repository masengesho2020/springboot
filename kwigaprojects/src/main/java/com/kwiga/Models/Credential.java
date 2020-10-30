package com.kwiga.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="credential")
public class Credential {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
    //@NotEmpty
	private int credentId;
    
	@Column(name="username")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{username.error}")
	private String userName;
	
	@Column(name="passowrd")
	//@NotEmpty 
	//@Size(min=6, max=25, message="{password.error}")
	private String password;
	
	
//	@OneToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private User user;
	
	public int getCredentId() {
		return credentId;
	}
	public void setCredentId(int credentId) {
		this.credentId = credentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

//	@Override
//	public String toString() {
//		return "Credential [credentId=" + credentId + ", userName=" + userName + ", password=" + password + "]";
//	}
}