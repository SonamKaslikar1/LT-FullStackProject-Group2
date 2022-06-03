/**
 * 
 */
package com.lt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lt.service.AdminService;
import com.lt.service.AdminServiceInterface;


/**
 * @author admin
 *
 */
@Configuration
public class AdminConfig {

	@Bean(name = "adminBean")
	public AdminServiceInterface adminService() {
		return new AdminService();
	}
	
}
