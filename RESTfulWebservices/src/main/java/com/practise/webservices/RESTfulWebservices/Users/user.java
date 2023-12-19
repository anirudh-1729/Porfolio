package com.practise.webservices.RESTfulWebservices.Users;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name ="user_details")
public class user {
	
    protected user() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2 , message = "Name should be atleast 2 characters")
	@JsonProperty("User_name")
	private String name;
	
	@Past(message = "Date should be in past")
	@JsonProperty("Birthday")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "User")
	@JsonIgnore
	private List<Post> posts;
	
	public user(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}


	

}
