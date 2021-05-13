package com.jawaher.mum.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "schedule")

public class Schedule {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int schudleID ;
	
	@JoinColumn(name="blockID" ,nullable=false)
	@OneToMany(fetch= FetchType.EAGER) 
	private Block block ;
	
	@JoinColumn(name="sectionID" ,nullable=false)
	@ManyToOne(fetch= FetchType.EAGER) 
	private Section section ;
	
	private Date year; 
	
	
	
	
	

}
