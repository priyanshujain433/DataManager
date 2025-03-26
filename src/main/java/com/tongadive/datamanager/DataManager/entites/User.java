package com.tongadive.datamanager.DataManager.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addId", referencedColumnName = "addId")
	private Address address;
	
	
	public User() {
		//Auto-generated constructor stub
	}
	public User(Integer userId, String name, String email, Integer age, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
