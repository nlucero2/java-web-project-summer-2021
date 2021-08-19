package com.websitebase.controller;

//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//
//@WebServlet("/DbTester")
//@PropertySource("classpath:application.properties")
public class DbTester /*extends HttpServlet*/ {
	
//	// create a variable that holds the database properties
//	@Autowired
//	private Environment environment;
//		
//		
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		// setup connection variables
//		String user = environment.getProperty("jdbc.user");
//		String pass = environment.getProperty("jdbc.password");
//
//		String jdbcUrl = environment.getProperty("jdbc.url"); 
//		String driver = environment.getProperty("jdbc.driver");
//
//
//		// get connection to database
//		try {
//
//			PrintWriter out = response.getWriter();
//
//			out.println("Connecting to the database: " + jdbcUrl + "\n\n");
//			System.out.println("\n*** Connecting to the database: " + jdbcUrl + " ***\n");		// ***optional line of code***
//
//			Class.forName(driver);
//
//			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
//
//			out.println("\nConnection SUCCESSFUL!!!");
//			System.out.println("\n\n********** Connection SUCCESSFUL!!! **********\n\n");							// ***optional line of code***
//
//			myConn.close();
//
//		} catch (Exception exc) {
//
//			exc.printStackTrace();
//			throw new ServletException(exc);
//
//		}
//
//
//	}
	
	
}
