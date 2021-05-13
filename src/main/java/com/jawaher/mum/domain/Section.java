package com.jawaher.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sections")

public class Section {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int sectionID ;
	
	
	@JoinColumn(name="blockID" ,nullable=false)
	@OneToOne(fetch= FetchType.EAGER) 
	private Block block ;
	
	@JoinColumn(name="courseID" ,nullable=false)
	@OneToOne(fetch= FetchType.EAGER) 
	private Course course ;
	
	@JoinColumn(name="facultyID" ,nullable=false)
	@OneToOne(fetch= FetchType.EAGER) 
	private Faculty faculty;
	
	
	private int number; 

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the sectionID
	 */
	public int getSectionID() {
		return sectionID;
	}

	/**
	 * @param sectionID the sectionID to set
	 */
	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	/**
	 * @return the block
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * @param block the block to set
	 */
	public void setBlock(Block block) {
		this.block = block;
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
	
	
	

	

}
