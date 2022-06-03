/**
 * 
 */
package com.lt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author admin
 *
 */
@Configuration
@Import({ UserConfig.class, AdminConfig.class, StudentConfig.class,
		ProfessorConfig.class })

public class AppConfig {

}
