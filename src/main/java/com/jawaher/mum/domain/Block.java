package com.jawaher.mum.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "blocks")

public class Block {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long blockID ;
	
	@JoinColumn(name="entryID" ,nullable=false)
	@ManyToOne(fetch= FetchType.EAGER) 
	private Entry entry ;
	
	
	
	/**
	 * @return the entry
	 */
	public Entry getEntry() {
		return entry;
	}
	/**
	 * @param entry the entry to set
	 */
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	private String blockName; 
	private String entryName;
	private int FPPnum;
	private int MPPnum;
	private Date startDate;
	/**
	 * @return the blockID
	 */
	public Long getBlockID() {
		return blockID;
	}
	/**
	 * @param blockID the blockID to set
	 */
	public void setBlockID(Long blockID) {
		this.blockID = blockID;
	}
	/**
	 * @return the blockName
	 */
	public String getBlockName() {
		return blockName;
	}
	/**
	 * @param blockName the blockName to set
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	/**
	 * @return the entryName
	 */
	public String getEntryName() {
		return entryName;
	}
	/**
	 * @param entryName the entryName to set
	 */
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	/**
	 * @return the fPPnum
	 */
	public int getFPPnum() {
		return FPPnum;
	}
	/**
	 * @param fPPnum the fPPnum to set
	 */
	public void setFPPnum(int fPPnum) {
		FPPnum = fPPnum;
	}
	/**
	 * @return the mPPnum
	 */
	public int getMPPnum() {
		return MPPnum;
	}
	/**
	 * @param mPPnum the mPPnum to set
	 */
	public void setMPPnum(int mPPnum) {
		MPPnum = mPPnum;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */

}
