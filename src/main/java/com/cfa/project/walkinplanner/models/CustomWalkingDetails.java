/**
 * 
 */
package com.cfa.project.walkinplanner.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author SANTOSH
 *
 */
public class CustomWalkingDetails {

	/**
	 * 
	 */
	
private Long id;
	
	@NotNull
	private String venu;
	
	@NotNull
	private String shortVenue;
	  
	@Temporal(TemporalType.DATE)
	private Date walkingdate;
	  
	@Temporal(TemporalType.TIME)
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date walkingTime;
	
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_address")
	private String companyAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	
	public CustomWalkingDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVenu() {
		return venu;
	}

	public void setVenu(String venu) {
		this.venu = venu;
	}

	public String getShortVenue() {
		return shortVenue;
	}

	public void setShortVenue(String shortVenue) {
		this.shortVenue = shortVenue;
	}

	public Date getWalkingdate() {
		return walkingdate;
	}

	public void setWalkingdate(Date walkingdate) {
		this.walkingdate = walkingdate;
	}

	public Date getWalkingTime() {
		return walkingTime;
	}

	public void setWalkingTime(Date walkingTime) {
		this.walkingTime = walkingTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
