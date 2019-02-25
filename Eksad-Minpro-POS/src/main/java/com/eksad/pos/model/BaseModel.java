package com.eksad.pos.model;

import java.util.Date;

import javax.persistence.Column;

public class BaseModel {
	private Integer createdBy;
	private Date createdOn;
	private Integer modifiedBy;
	private Date modifiedOn;
	private Boolean active;
	
	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name = "modified_by")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Column(name = "modified_on")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column(name = "active")
	public Boolean getActive() {
		return active;
	}	
	
	public void setActive(Boolean active) {
		this.active = active;
	}
}
