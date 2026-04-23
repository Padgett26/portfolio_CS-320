///////////////////////////////////
// Project structure and starter code written by Jason Padgett, with tutorial help from:
// Resource:
// Clinton Bush. SNHU. CS320 - Milestone Series - Video 1, 2, 3. https://youtu.be/qgM3dTF3PSI?si=WJNMzqFN7fBd0sDb.
// All other code content and tests written by Jason Padgett
//////////////////////////////////

package org.snhu.cs320.contact;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {
	// declare our INSTANCE
	private static ContactService INSTANCE;
	
	// create our in-memory database
	Map<String, Contact> database = new ConcurrentHashMap<>();
	
	// constructor
	private ContactService() {}
	
	// if an instance object does not exist, create it
	public static synchronized ContactService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ContactService();
		}
		return INSTANCE;
	}
	
	// add a contact object to the database
	public boolean add(Contact contact) {
		return database.putIfAbsent(contact.getId(), contact) == null;
	}
	
	// delete an entry from the database
	public boolean delete(String id) {
		return database.remove(id) != null;
	}
	
	// update all non-id fields for a contact in the database
	public boolean update(String id, Contact updated) throws Exception {
		Contact existing = database.get(id);
		
		if (existing == null) return false;
		
		existing.setFirstName(updated.getFirstName());
		existing.setLastName(updated.getLastName());
		existing.setPhone(updated.getPhone());
		existing.setAddress(updated.getAddress());
		
		return true;
	}
	
	// update a firstName entry in a specific contact
	public boolean updateFirstName(String id, String newValue) throws Exception {
		Contact existing = database.get(id);
		
		if (existing == null) return false;
		
		existing.setFirstName(newValue);
		
		return true;
	}
	
	// update a lastName entry in a specific contact
	public boolean updateLastName(String id, String newValue) throws Exception {
		Contact existing = database.get(id);
		
		if (existing == null) return false;
		
		existing.setLastName(newValue);
		
		return true;
	}
	
	// update a phone entry in a specific contact
	public boolean updatePhone(String id, String newValue) throws Exception {
		Contact existing = database.get(id);
		
		if (existing == null) return false;
		
		existing.setPhone(newValue);
		
		return true;
	}
	
	// update an address entry in a specific contact
	public boolean updateAddress(String id, String newValue) throws Exception {
		Contact existing = database.get(id);
		
		if (existing == null) return false;
		
		existing.setAddress(newValue);
		
		return true;
	}
}
