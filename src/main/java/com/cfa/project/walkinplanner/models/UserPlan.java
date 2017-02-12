package com.cfa.project.walkinplanner.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "user_plan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
public class UserPlan implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;

    @NotNull
	@Column(unique = true)
    private String planName;
	private String owner;
	
	@Column(columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean isComplete;
	
	@Column(columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean isUnderReview;
	
	@Column(columnDefinition = "BIT(1) DEFAULT b'0'")
	private Boolean isLocked;
	
	
	
	@ManyToOne
	private User user;
	
	
	
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean markDelete;
	

	
	private String co_planner;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean isUnderReviewer;
	
	private String reviewer;
	
	@Column(unique=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	
	//@JsonSerialize(using = LocalDateTimeSerializer.class)	
	//@JsonDeserialize(using = LocalDateTimeDeSerializer.class)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime timeStamp = LocalDateTime.now();
	
	
	
	public UserPlan(){
		
	}
    
    
	
    
   
    
    
    public UserPlan(Long id, String planName, String owner, Boolean isComplete, Boolean isUnderReview, Boolean isLocked,
			User user, Boolean markDelete, LocalDateTime createdTime, String co_planner, Boolean isUnderReviewer,
			String reviewer) {
		super();
		this.id = id;
		this.planName = planName;
		this.owner = owner;
		this.isComplete = isComplete;
		this.isUnderReview = isUnderReview;
		this.isLocked = isLocked;
		this.user = user;
		this.markDelete = markDelete;

		this.co_planner = co_planner;
		this.isUnderReviewer = isUnderReviewer;
		this.reviewer = reviewer;
	}







	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getMarkDelete() {
		return markDelete;
	}

	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}

	

	public String getCo_planner() {
		return co_planner;
	}

	public void setCo_planner(String co_planner) {
		this.co_planner = co_planner;
	}

	public Boolean getIsUnderReviewer() {
		return isUnderReviewer;
	}

	public void setIsUnderReviewer(Boolean isUnderReviewer) {
		this.isUnderReviewer = isUnderReviewer;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}


	public Boolean getIsComplete() {
		return isComplete;
	}


	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}


	public Boolean getIsUnderReview() {
		return isUnderReview;
	}


	public void setIsUnderReview(Boolean isUnderReview) {
		this.isUnderReview = isUnderReview;
	}


	public Boolean getIsLocked() {
		return isLocked;
	}


	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}







	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}







	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}



















  
}
