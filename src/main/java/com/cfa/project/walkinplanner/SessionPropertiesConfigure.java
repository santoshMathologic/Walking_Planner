package com.cfa.project.walkinplanner;

import javax.servlet.MultipartConfigElement;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionPropertiesConfigure {

	public SessionPropertiesConfigure() {
		
	}
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}
	@Bean
	MultipartConfigElement multipartConfigElement() {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    factory.setMaxFileSize("5120MB");
	    factory.setMaxRequestSize("5120MB");
	    return factory.createMultipartConfig();
	}

}
