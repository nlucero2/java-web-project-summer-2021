package com.websitebase.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// create a reference to the security data source
	@Autowired
	private DataSource securityDataSource;
	
	
	// we use jdbc info for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.out.println("\n********** configure(AuthenticationManagerBuilder auth) method in -> SecurityConfig class **********");
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		System.out.println("\n********** configure(HttpSecurity http) method in -> SecurityConfig class **********");
		
		http.authorizeRequests().antMatchers("/list-of-contact-info").hasRole("ADMIN").and().formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll().and().logout().logoutSuccessUrl("/").permitAll().and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		
		
		
		
		// ***********************************************************************************************************************************************
		//		********** DELETE **********
		
//		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE")
//		.antMatchers("/leaders/**").hasRole("MANAGER")
//		.antMatchers("/systems/**").hasRole("ADMIN").and().formLogin()
//		.loginPage("/showMyLoginPage")
//		.loginProcessingUrl("/authenticateTheUser")
//		.permitAll().and().logout().permitAll().and()
//		.exceptionHandling().accessDeniedPage("/access-denied");
		
		//		********** DELETE **********
		// ***********************************************************************************************************************************************
		
	}





//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**","/**/*.js", "/**/*.css");
//		
//	}
	
	
	
}
