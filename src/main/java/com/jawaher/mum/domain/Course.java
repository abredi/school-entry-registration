package com.jawaher.mum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class Course {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long ID;
	  	
	    @Column(name = "course_name")
	  	private String courseName ;
	    
	    
	    @Column(name = "course_level")
	  	private int courseLevel;
	    
	    @Column(name = "credit")
	  	private int credit ;
	  	
	    /**
		 * @return the iD
		 */
		public Long getID() {
			return ID;
		}

		/**
		 * @param iD the iD to set
		 */
		public void setID(Long iD) {
			ID = iD;
		}

		/**
		 * @return the faculty
		 */
		public Faculty getFaculty() {
			return faculty;
		}

		/**
		 * @param faculty the faculty to set
		 */
		public void setFaculty(Faculty faculty) {
			this.faculty = faculty;
		}

		/**
		 * @return the courseName
		 */
		public String getCourseName() {
			return courseName;
		}

		@Column(name = "prequisite")
	  	private Course prequisite;
	    
	    @JoinColumn(name="facultyID" ,nullable=false)
		@ManyToOne(fetch= FetchType.EAGER) 
		private Faculty faculty ;
		

		/**
		 * @return the id
		 */
		public Long getId() {
			return ID;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.ID = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return courseName;
		}

		/**
		 * @param name the name to set
		 */
		public void setCourseName(String name) {
			this.courseName = name;
		}

		/**
		 * @return the courseLevel
		 */
		public int getCourseLevel() {
			return courseLevel;
		}

		/**
		 * @param courseLevel the courseLevel to set
		 */
		public void setCourseLevel(int courseLevel) {
			this.courseLevel = courseLevel;
		}

		/**
		 * @return the credit
		 */
		public int getCredit() {
			return credit;
		}

		/**
		 * @param credit the credit to set
		 */
		public void setCredit(int credit) {
			this.credit = credit;
		}

		/**
		 * @return the prequisite
		 */
		public Course getPrequisite() {
			return prequisite;
		}

		/**
		 * @param prequisite the prequisite to set
		 */
		public void setPrequisite(Course prequisite) {
			this.prequisite = prequisite;
		}
	  	

}
