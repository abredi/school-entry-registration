package com.jawaher.mum.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "entries")
public class Entry {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int entryID ;
	

	

	
	private String entryName;
	private int FPPnum;
	private int MPPnum;
	private Date startDate;
	private Date endDate;
	
	
	
	
	/**
	 * @return the entryID
	 */
	public int getEntryID() {
		return entryID;
	}


	/**
	 * @param entryID the entryID to set
	 */
	public void setEntryID(int entryID) {
		this.entryID = entryID;
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
	public Date getEndDate() {
		return endDate;
	}


	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	/**
	 * @return the blockList
	 */
	public Set<Block> getBlockList() {
		return blockList;
	}


	/**
	 * @param blockList the blockList to set
	 */
	public void setBlockList(Set<Block> blockList) {
		this.blockList = blockList;
	}



	@OneToMany(cascade = CascadeType.ALL , mappedBy="entry")
	private Set<Block> blockList = new HashSet<Block>() ;
	
	
	public void addBlock(Block block) {
		blockList.add(block);
		block.setEntry(this);
		
		
	}

}
