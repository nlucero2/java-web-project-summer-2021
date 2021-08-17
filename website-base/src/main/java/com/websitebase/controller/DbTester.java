package com.websitebase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DbTester")
public class DbTester extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false"; 
		String driver = "com.mysql.jdbc.Driver";


		// get connection to database
		try {

			PrintWriter out = response.getWriter();

			out.println("Connecting to the database: " + jdbcUrl + "\n\n");
			System.out.println("\n*** Connecting to the database: " + jdbcUrl + " ***\n");		// ***optional line of code***

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			out.println("\nConnection SUCCESSFUL!!!");
			System.out.println("\n*** Connection SUCCESSFUL!!! ***\n");							// ***optional line of code***

			myConn.close();

		} catch (Exception exc) {

			exc.printStackTrace();
			throw new ServletException(exc);

		}


	}
	
	
}
