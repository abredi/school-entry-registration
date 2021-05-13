package com.jawaher.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "faculty")
public class Faculty {
	
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
	    
	    @JoinColumn(name="courseID" ,nullable=false)
		@ManyToOne(fetch= FetchType.EAGER) 
		private Course course ;

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the course
		 */
		public Course getCourse() {
			return course;
		}

		/**
		 * @param course the course to set
		 */
		public void setCourse(Course course) {
			this.course = course;
		}
	    
	    
		


}
