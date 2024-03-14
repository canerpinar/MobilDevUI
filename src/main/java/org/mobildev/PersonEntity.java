package org.mobildev;

import java.util.UUID;

public class PersonEntity {

	private String uuid;
	private String ad;
	private String soyad;
	private String email;
	private String password;
	
	public PersonEntity(String ad, String soyad, String email, String password) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.password = password;
	}
	
	
	public PersonEntity() {
		super();
	}


	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String name) {
		this.ad = name;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
