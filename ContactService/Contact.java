///////////////////////////////////
// Project structure and starter code written by Jason Padgett, with tutorial help from:
// Resource:
// Clinton Bush. SNHU. CS320 - Milestone Series - Video 1, 2, 3. https://youtu.be/qgM3dTF3PSI?si=WJNMzqFN7fBd0sDb.
// All other code content and tests written by Jason Padgett
//////////////////////////////////

package org.snhu.cs320.contact;

import org.snhu.cs320.validation.Validation;

public class Contact {
	// define class variables
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// constructor
	public Contact(String id, String firstName, String lastName, String phone, String address) throws Exception {
		super();
		
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}

	// get firstName
	public String getFirstName() {
		return firstName;
	}

	// set firstName variable, and validating the input string
	public void setFirstName(String firstName) throws Exception {
		Validation.validateNotNull(firstName, "firstName");
		Validation.validateNotBlank(firstName, "firstName");
		Validation.validateLength(firstName, "firstName", 1, 10);
		
		this.firstName = firstName;
	}

	// get lastName
	public String getLastName() {
		return lastName;
	}

	// set lastName variable, and validating the input string
	public void setLastName(String lastName) throws Exception {
		Validation.validateNotNull(lastName, "lastName");
		Validation.validateNotBlank(lastName, "lastName");
		Validation.validateLength(lastName, "lastName", 1, 10);
		
		this.lastName = lastName;
	}

	// get phone
	public String getPhone() {
		return phone;
	}

	// set phone variable, and validating the input string
	public void setPhone(String phone) throws Exception {
		Validation.validateNotNull(phone, "phone");
		Validation.validateNotBlank(phone, "phone");
		Validation.validateNumeric(phone, "phone");
		Validation.validatePhoneLength(phone, "phone", 10);
		this.phone = phone;
	}

	// get address
	public String getAddress() {
		return address;
	}

	// set address variable, and validating the input string
	public void setAddress(String address) throws Exception {
		Validation.validateNotNull(address, "address");
		Validation.validateNotBlank(address, "address");
		Validation.validateLength(address, "address", 1, 30);
		this.address = address;
	}

	// get id
	public String getId() {
		return id;
	}
	
	// set id variable, and validating the input string
	private void setId(String id) throws Exception {
		Validation.validateNotNull(id, "id");
		Validation.validateNotBlank(id, "id");
		Validation.validateLength(id, "id", 1, 10);
		this.id = id;
	}
}
