package com.example.demo.app.iquiry;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InquiryForm {
	
	@Size(min = 1 ,max =20 , message = "Please input 20 characters or less")
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String contents;
	
	public InquiryForm() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setAccount(String email) {
		this.email = email;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}


}
