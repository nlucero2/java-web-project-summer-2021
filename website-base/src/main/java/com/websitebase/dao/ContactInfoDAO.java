package com.websitebase.dao;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.websitebase.entity.ContactInfo;
//
//@Repository
public class ContactInfoDAO implements ContactInfoDOAInterface {
	
//	// need to inject the session factory
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	
//	// this retrieves all contact info entries from the database
//	@Override
//	public List<ContactInfo> getAllContactInfo() {
//		
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// create query
//		Query<ContactInfo> theQuery = currentSession.createQuery("from ContactInfo", ContactInfo.class);		/* maybe ("from contact_info_table", ContactInfo.class) */
//		
//		// execute the query and get the result list
//		List<ContactInfo> contactInfoList = theQuery.getResultList();
//		
//		// return the list of results
//		return contactInfoList;
//	}
//	
//	
//	// for saving new and modified contact info in the database
//	@Override
//	public void saveContactInfo(ContactInfo theContactInfo) {
//		
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// save the customer!!!
//		currentSession.saveOrUpdate(theContactInfo);
//	}
//	
//	
//	// this retrieves one contact info entry from the database based on the given primary key
//	@Override
//	public ContactInfo getContactInfo(int theId) {
//		
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// now retrieve from the database using the primary key
//		ContactInfo theContactInfo = currentSession.get(ContactInfo.class, theId);
//		
//		return theContactInfo;
//	}
//	
//	
//	// this deletes one contact info entry from the database based on the given primary key
//	@Override
//	public void deleteContactInfo(int theId) {
//		
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// delete the customer object from the database using the primary key
//		Query<?> theQuery = currentSession.createQuery("delete from ContactInfo where id=:contactInfoId");	/* maybe ("delete from contact_info_table where id=:contactInfoId") */
//		
//		theQuery.setParameter("contactInfoId", theId);
//		
//		theQuery.executeUpdate();
//	}
//	
//	
//	// this is for searching the contact info database for a specific contact info
//	@Override
//	public List<ContactInfo> searchContactInfo(String theSearchName) {
//		
//		//  remove leading and trailing white space from the argument passed into this method
//		theSearchName = theSearchName.trim();
//		
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// create query and set to null
//		Query<ContactInfo> theQuery = null;
//		
//		// search by name if theSearchName is not empty
//		if (theSearchName != null && theSearchName.length() > 0) {
//			
//			// search both firtsName and lastName
//			theQuery = currentSession.createQuery("from ContactInfo where lower(firstName) like :theName or lower(lastName) like :theName order by lastName", ContactInfo.class);
//										/* maybe ("from contact_info_table where lower(firstName) like :theName or lower(lastName) like :theName order by lastName", ContactInfo.class); */
//			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
//			
//		} else {
//			
//			// if theSearchName is empty just return all contact info entries from the database
//			theQuery = currentSession.createQuery("from ContactInfo", ContactInfo.class);
//			
//		}
//		
//		// execute the query and get the list of results
//		List<ContactInfo> contactInfoList = theQuery.getResultList();
//		
//		// return the list of results
//		return contactInfoList;
//	}
	
	
	
	
	
	
	
	
	
	
	
	// this is for sorting the contact info list  ***if we want sorting***
//	@Override
//	public List<ContactInfo> getAllContactInfo(int theSortField) {
//	
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		// determine sort field
//		String theFieldName = null;
//		
//		switch (theSortField) {
//			case SortUtils.FIRST_NAME:
//				theFieldName = "firstName";
//				break;
//			case SortUtils.LAST_NAME:
//				theFieldName = "lastName";
//				break;
//			case SortUtils.EMAIL:
//				theFieldName = "email";
//				break;
//				
//			default:
//				// if nothing matches, the default sort field to sort by is lastName
//				theFieldName = "lastName";
//		}
//		
//		// create a query
//		String queryString = "from ContactInfo order by " + theFieldName;
//		Query<ContactInfo> theQuery = currentSession.createQuery(queryString, ContactInfo.class);
//		
//		// execute the query and get the list of results
//		List<ContactInfo> contactInfoList = theQuery.getResultList();
//		
//		// return the results
//		return contactInfoList;
//	}

}
