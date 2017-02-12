package com.cfa.project.walkinplanner.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.cfa.project.walkinplanner.models.CompanyDetailsModel;

import java.lang.String;
import java.util.List;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<CompanyDetailsModel, Long>{
	
	//Page<CompanyDetailsModel> findByCompanyName(@Param("name")String name, Pageable pageable);
	List<CompanyDetailsModel> findByCompanyName(@Param("name")String name);
	Page<CompanyDetailsModel> findByCompanyNameContains(@Param("companyName")String companyName, Pageable pageable);
	CompanyDetailsModel findByCompanyNameContains(@Param("companyName")String companyName);
	
	

	@Query("Select c from CompanyDetailsModel as c where ( c.companyName LIKE %:companyName% or :companyName is '%%' or :companyName is null ) AND "
			+ "( c.city LIKE %:city% or :city is '%%' or :city is null)")
	Page<CompanyDetailsModel> findByAllParams(
			@Param("companyName") String companyName,
			@Param("city") String city,
			Pageable pageable);
	

}

