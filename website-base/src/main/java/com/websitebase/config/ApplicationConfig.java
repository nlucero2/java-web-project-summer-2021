package com.websitebase.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
//import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.websitebase")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	// create a variable that holds the database properties
	@Autowired
	private Environment environment;
	
	// create a logger for diagnostics
//	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Bean
	public DataSource theDataSource() {
		
		System.out.println("********** theDataSource() method in -> ApplicationConfig class has started **********");
		
		// create connection pool
		ComboPooledDataSource theDataSource = new ComboPooledDataSource();
		
		// set the jdbc driver
		try {
		
			theDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		
		} catch (PropertyVetoException exc) {
			
			System.out.println("********** Error in try/catch inside -> theDataSource() method in -> ApplicationConfig class **********");
			throw new RuntimeException(exc);
		
		}
		
		// set the database connection properties
		theDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		theDataSource.setUser(environment.getProperty("jdbc.user"));
		theDataSource.setPassword(environment.getProperty("jdbc.password"));
		
		// set the connection pool properties
		theDataSource.setInitialPoolSize(getPropertyInt("connection.pool.initialPoolSize"));
		theDataSource.setMinPoolSize(getPropertyInt("connection.pool.minPoolSize"));
		theDataSource.setMaxPoolSize(getPropertyInt("connection.pool.maxPoolSize"));
		theDataSource.setMaxIdleTime(getPropertyInt("connection.pool.maxIdleTime"));
		
//		// log the connection properties
//		logger.info("********** The jdbc.url is: \"" + environment.getProperty("jdbc.url") + "\" **********");
//		logger.info("********** The jdbc.user is: \"" + environment.getProperty("jdbc.user") + "\" **********");
//		logger.info("********** The jdbc.password is: \"" + environment.getProperty("jdbc.password") + "\" **********");

		System.out.println("********** theDatasource() method in -> ApplicationConfig class has finished **********");
		
		return theDataSource;
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
	
	
	
	
	// ***************** code for ContactInfo database configuration *****************

	
	
	private Properties getHibernateProperties() {
		
		System.out.println("********** getHibernateProperties() method in -> ApplicationConfig class has started **********");

		// set the hibernate properties
		Properties props = new Properties();
		
		props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		
		System.out.println("********** getHibernateProperties() method in -> ApplicationConfig class has finished **********");
		
		return props;
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		System.out.println("********** sessionFactory() method in -> ApplicationConfig class has started **********");

		// create session factory
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactoryBean.setDataSource(theDataSource());
		sessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		
		System.out.println("********** sessionFactory() method in -> ApplicationConfig class has finished **********");
		
		return sessionFactoryBean;
	}
	
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory theSessionFactory) {
		
		System.out.println("********** transactionManager(SessionFactory theSessionFactory) method in -> ApplicationConfig class has started **********");

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(theSessionFactory);
		
		System.out.println("********** transactionManager(SessionFactory theSessionFactory) method in -> ApplicationConfig class has finished **********");
		
		return txManager;
	}
	
}
