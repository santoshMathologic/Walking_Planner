package com.cfa.project.walkinplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cfa.project.walkinplanner.models.User;
import com.cfa.project.walkinplanner.repository.UserRepository;

import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@ComponentScan(basePackages = { "com.cfa.project.walkinplanner", "com.cfa.project.walkinplanner.custom.repository",
		"com.cfa.project.walkinplanner.controllers", "com.cfa.project.walkinplanner.models","com.cfa.project.walkingplanner.utils"})
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.cfa.project.walkinplanner.repository"})
@SpringBootApplication
public class WalkInPlannerApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WalkInPlannerApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(WalkInPlannerApplication.class, args);
	}
}
@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService());
		
	}
	
	@Bean
	UserDetailsService userDetailsService(){
		
		return new UserDetailsService(){

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				
				User user = userRepo.findByUsernameAndIsActive(username,true);
				if(user!=null){
					
					return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true
								,true,true,AuthorityUtils.createAuthorityList(user.getRole().getName()));
				}else{
					
					throw new UsernameNotFoundException("user not found");
				}	
			}
			
			
		};
	}
}

