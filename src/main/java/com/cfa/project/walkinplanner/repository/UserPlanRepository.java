/**
 * 
 */
package com.cfa.project.walkinplanner.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cfa.project.walkinplanner.models.UserPlan;





/**
 * @author RAKESH
 *
 */
@RepositoryRestResource

public interface UserPlanRepository extends JpaRepository<UserPlan,Long> {
	Page<UserPlan> findAll(Pageable pageable);
	UserPlan findByUser_username(@Param("username")String username);
	
	 
	 @Query("SELECT u.planName,u.owner,p.username from UserPlan as u JOIN u.user as p where ( u.planName LIKE %:planName% or :planName is '%%' or :planName is null ) AND ( u.owner LIKE %:owner% or :owner is '%%' or :owner is null )")
	 Page<UserPlan> findByAllParams(@Param("planName") String planName,@Param("owner") String owner,Pageable pageable);

}
