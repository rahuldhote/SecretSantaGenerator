package com.secretsanta.pojo;

public class SecretSantaMember {
	private String name;
	private String email;
	private String location;
	
	
	public SecretSantaMember() {
		super();
	}
	public SecretSantaMember(String name) {
		super();
		this.name = name;
	}
	public SecretSantaMember(String name, String email, String location) {
		super();
		this.name = name;
		this.email = email;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "SecretSantaMember [name=" + name + ", email=" + email + ", location=" + location + "]";
	}
	
	

}
