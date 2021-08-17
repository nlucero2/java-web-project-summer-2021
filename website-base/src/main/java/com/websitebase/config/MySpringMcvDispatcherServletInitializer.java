package com.websitebase.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMcvDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	
	// we DON'T need to modify this method
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	
	
	// we use the DemoAppConfig class that we created to allow use of MVC and .jsp files
	// this method replaces the web.xml code:
 	//	<servlet>
    //		<servlet-name>dispatcher</servlet-name>
    //		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    //			
    //			<init-param>
    //				<param-name>contextConfigLocation</param-name>
    //				<param-value>/WEB-INF/spring-mvc-crud-demo-servlet.xml</param-value>
   	//			</init-param>
    //			
	//			<load-on-startup>1</load-on-startup>
  	//	</servlet>
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DemoAppConfig.class};
	}
	
	
	
	// this method replaces the web.xml code:
	//	<servlet-mapping>
	//		<servlet-name>dispatcher<servlet-name>
	//		<url-pattern>/<url-pattern>
	//	<servlet-mapping>
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
