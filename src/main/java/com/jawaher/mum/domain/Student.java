package com.jawaher.mum.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Student {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotEmpty(message = "The first name has to have a value")
	    private String firstName;
	    @NotEmpty(message = "The  last name has to have a value")
	    private String lastName;
	    @NotEmpty(message = "The  email has to have a value")
	    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
	    private String email;

	    public Student () {}
	    public Student(@NotNull String firstName, String lastName, String email) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	    }

	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

}
