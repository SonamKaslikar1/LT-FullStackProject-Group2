/**
 * 
 */
package com.lt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lt.service.CourseService;
import com.lt.service.CourseServiceInterface;
import com.lt.service.ProfessorService;
import com.lt.service.ProfessorServiceInterface;

/**
 * @author admin
 *
 */
@Configuration
public class ProfessorConfig {

	@Bean(name = "professorBean")
	public ProfessorServiceInterface professorService() {
		return new ProfessorService();
	}
	
	@Bean(name = "courseBean")
	public CourseServiceInterface courseService() {
		return new CourseService();
	}
}
