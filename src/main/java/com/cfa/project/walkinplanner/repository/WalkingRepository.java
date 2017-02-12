package com.cfa.project.walkinplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.cfa.project.walkinplanner.models.WalkInDetailsModel;

@RepositoryRestResource
public interface WalkingRepository extends JpaRepository<WalkInDetailsModel, Long>{
	


}

