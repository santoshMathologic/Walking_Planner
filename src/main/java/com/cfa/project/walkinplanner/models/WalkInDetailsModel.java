package com.cfa.project.walkinplanner.models;
/*
 * walking_details table creation in Database
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="walkin_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class WalkInDetailsModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//------------------Declaring Variables "Fields"--------------------------
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String venu;
	
	@NotNull
	private String shortVenue;
	  
	@Temporal(TemporalType.DATE)
	private Date walkingdate;
	  
	@Temporal(TemporalType.TIME)
	// @JsonSerialize(using = LocalTimeSerializer.class)
	// @JsonDeserialize(using = LocalTimeDeSerializer.class)
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date walkingTime;
	
	// Mapped by CompanyDetailsModel - Many to One Relationship
	@ManyToOne
	//@JsonBackReference
	//@JoinColumn(name = "company_details_id")	
	private CompanyDetailsModel companydetails;

	
	
	//-------------------------------Constructors-------------------------------
	 
	public WalkInDetailsModel() {
		super();
	}

	/**
	 * @param id
	 * @param venu
	 * @param walkingdate
	 * @param walkingTime
	 * @param companydetails
	 * @param shortVenue
	 */
	public WalkInDetailsModel(Long id, String venu, Date walkingdate, Date walkingTime, String shortVenue,
			CompanyDetailsModel companydetails) {
		super();
		this.id = id;
		this.venu = venu;
		this.walkingdate = walkingdate;
		this.walkingTime = walkingTime;
		this.shortVenue = shortVenue;
		this.companydetails = companydetails;
	}
	
	//-------------------------Getters and Setters----------------------------
	
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

	public CompanyDetailsModel getCompanydetails() {
		return companydetails;
	}

	public void setCompanydetails(CompanyDetailsModel companydetails) {
		this.companydetails = companydetails;
	}

	public String getShortVenue() {
		return shortVenue;
	}

	public void setShortVenue(String shortVenue) {
		this.shortVenue = shortVenue;
	}

}
