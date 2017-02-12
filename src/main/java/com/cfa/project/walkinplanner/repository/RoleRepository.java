package com.cfa.project.walkinplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cfa.project.walkinplanner.models.Role;




@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
