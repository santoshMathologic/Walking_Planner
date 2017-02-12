package com.cfa.project.walkinplanner.models;
/*
 * Company_details table creation in Database
 */
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="company_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class CompanyDetailsModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//------------------Declaring Variables "Fields"--------------------------
	@Id
	@GeneratedValue
	private Long id;
	
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
	
	// Mapped to WalkingDetailsModel - One to Many Relationship
	@OneToMany(mappedBy="companydetails",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<WalkInDetailsModel> walkings = new LinkedList<WalkInDetailsModel>();

	/**
	 * 
	 */
	//-------------------------------Constructor-------------------------------
	public CompanyDetailsModel() {
		super();
	}

	//-------------------------Getters and Setters------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<WalkInDetailsModel> getWalkings() {
		return walkings;
	}

	public void setWalkings(List<WalkInDetailsModel> walkings) {
		this.walkings = walkings;
	}

}
