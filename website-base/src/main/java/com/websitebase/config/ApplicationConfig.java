package com.websitebase.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.websitebase")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	// create a variable that holds the database properties
	@Autowired
	private Environment environment;
	
	// create a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for the security datasource
	@Bean
	public DataSource securityDatasource() {
		
		
		System.out.println("********** securityDatasource() method in -> ApplicationConfig class has started **********");
		
		// create a connection pool
		ComboPooledDataSource securityDatasource = new ComboPooledDataSource();
		
		// set the jdbc driver class
		try {
			
			securityDatasource.setDriverClass(environment.getProperty("jdbc.driver"));
			
		} catch (PropertyVetoException exc) {
			
			System.out.println("********** Error in try/catch inside -> securityDatasource() method in -> ApplicationConfig class **********");
			throw new RuntimeException(exc);
		
		}
		
		// log the connection properties
		logger.info("********** The jdbc.url is: \"" + environment.getProperty("jdbc.url") + "\" **********");
		logger.info("********** The jdbc.user is: \"" + environment.getProperty("jdbc.user") + "\" **********");
		logger.info("********** The jdbc.password is: \"" + environment.getProperty("jdbc.password") + "\" **********");
		
		// set the database connection properties
		securityDatasource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDatasource.setUser(environment.getProperty("jdbc.user"));
		securityDatasource.setPassword(environment.getProperty("jdbc.password"));
		
		// set the connection pool properties
		securityDatasource.setInitialPoolSize(getPropertyInt("connection.pool.initialPoolSize"));
		securityDatasource.setMinPoolSize(getPropertyInt("connection.pool.minPoolSize"));
		securityDatasource.setMaxPoolSize(getPropertyInt("connection.pool.maxPoolSize"));
		securityDatasource.setMaxIdleTime(getPropertyInt("connection.pool.maxIdleTime"));
		
		System.out.println("********** securityDatasource() method in -> ApplicationConfig class has finished **********");
		
		return securityDatasource;
	}
	
	
	// define a bean for the ViewResolver
		// tells where the .jsp files are
	@Bean
	public ViewResolver viewResolver() {
		
		System.out.println("********** viewResolver() method in -> ApplicationConfig class has started **********");
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		System.out.println("********** viewResolver() method in -> ApplicationConfig class has finished **********");
		
		return viewResolver;
	}
	
	
	// this helper method reads an environment property and convert it to an int
	private int getPropertyInt(String propName) {
		
		System.out.print("********** getPropertyInt(String propName) method in -> ApplicationConfig class has started with: ");
		System.out.println("\"" + propName + "\" as it's argument **********");
		
		String strPropValue = environment.getProperty(propName);
		
		int intPropValue = Integer.parseInt(strPropValue);
		
		return intPropValue;
	}
	
}
