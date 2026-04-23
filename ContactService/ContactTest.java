///////////////////////////////////
// Project structure and starter code written by Jason Padgett, with tutorial help from:
// Resource:
// Clinton Bush. SNHU. CS320 - Milestone Series - Video 1, 2, 3. https://youtu.be/qgM3dTF3PSI?si=WJNMzqFN7fBd0sDb.
// All other code content and tests written by Jason Padgett
//////////////////////////////////

package org.snhu.cs320.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ContactTest {
	
	// test Contact object creation
	@Test
	void testSuccessfulCreation() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(contact)
			.hasFieldOrPropertyWithValue("id", "1")
			.hasFieldOrPropertyWithValue("firstName", "Jane")
			.hasFieldOrPropertyWithValue("lastName", "Doe")
			.hasFieldOrPropertyWithValue("phone", "1234567890")
			.hasFieldOrPropertyWithValue("address", "123 Maple Dr.");
	}
	
	// test set methods, id is not included because it is immutable
	@Test
	void testSuccessfulSetters() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		contact.setFirstName("John");
		contact.setLastName("Smith");
		contact.setPhone("0987654321");
		contact.setAddress("320 Oak Ln.");
		assertThat(contact)
			.hasFieldOrPropertyWithValue("firstName", "John")
			.hasFieldOrPropertyWithValue("lastName", "Smith")
			.hasFieldOrPropertyWithValue("phone", "0987654321")
			.hasFieldOrPropertyWithValue("address", "320 Oak Ln.");
	}
	
	// test with bad input values
	@CsvSource({
		"' ', Jane, Doe, 1234567890, 123 Maple Dr., id must not be blank", //Blank blank
		", Jane, Doe, 1234567890, 123 Maple Dr., id must not be null", // null Id
		"1234567890123, Jane, Doe, 1234567890, 123 Maple Dr., id must be at least 1 and no greater than 10 characters in length", // Id too long
		"1, ' ', Doe, 1234567890, 123 Maple Dr., firstName must not be blank", // firstName space
		"1,, Doe, 1234567890, 123 Maple Dr., firstName must not be null", // firstName null
		"1, JaneJaneJane, Doe, 1234567890, 123 Maple Dr., firstName must be at least 1 and no greater than 10 characters in length", // firstName too long
		"1, Jane, ' ', 1234567890, 123 Maple Dr., lastName must not be blank", // lastName space
		"1, Jane,, 1234567890, 123 Maple Dr., lastName must not be null", // lastName null
		"1, Jane, DoeDoeDoeDoe, 1234567890, 123 Maple Dr., lastName must be at least 1 and no greater than 10 characters in length", // lastName too long
		"1, Jane, Doe, ' ', 123 Maple Dr., phone must not be blank", // phone space
		"1, Jane, Doe,, 123 Maple Dr., phone must not be null", // phone null
		"1, Jane, Doe, 123456, 123 Maple Dr., phone must be 10 numbers in length", // phone too short
		"1, Jane, Doe, 1234567890123, 123 Maple Dr., phone must be 10 numbers in length", // phone too long
		"1, Jane, Doe, 1234567ABC, 123 Maple Dr., phone must contain only digits", // phone with letters
		"1, Jane, Doe, 123-456-78, 123 Maple Dr., phone must contain only digits", // phone with punctuation
		"1, Jane, Doe, 123 456 78, 123 Maple Dr., phone must contain only digits", // phone with spaces
		"1, Jane, Doe, 1234567890, ' ', address must not be blank", // address space
		"1, Jane, Doe, 1234567890,, address must not be null", // address null
		"1, Jane, Doe, 1234567890, 123 Maple Dr. 123 Maple Dr. 123 Maple Dr., address must be at least 1 and no greater than 30 characters in length", // address too long
	})
	@ParameterizedTest
	void testFailedCreation(String id, String firstName, String lastName, String phone, String address, String message) {
		assertThatThrownBy(() -> new Contact(id, firstName, lastName, phone, address))
		.isNotNull()
		.hasMessage(message);
	}
	
	// test firstName with bad input values
	@CsvSource ({
		", firstName must not be null",
		"' ', firstName must not be blank",
		"JaneJaneJane, firstName must be at least 1 and no greater than 10 characters in length"
	})
	@ParameterizedTest
	void testSetFirstName(String firstName, String message) throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThatThrownBy(() -> contact.setFirstName(firstName))
		.isNotNull()
		.hasMessage(message);
	}
	
	// test lastName with bad input values
	@CsvSource ({
		", lastName must not be null",
		"' ', lastName must not be blank",
		"DoeDoeDoeDoe, lastName must be at least 1 and no greater than 10 characters in length"
	})
	@ParameterizedTest
	void testSetLastName(String lastName, String message) throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThatThrownBy(() -> contact.setLastName(lastName))
		.isNotNull()
		.hasMessage(message);
	}
	
	// test phone with bad input values
	@CsvSource ({
		", phone must not be null",
		"' ', phone must not be blank",
		"123456, phone must be 10 numbers in length",
		"123456789123, phone must be 10 numbers in length",
		"123456ABC, phone must contain only digits",
		"123 456 78, phone must contain only digits",
		"123-456-78, phone must contain only digits",
	})
	@ParameterizedTest
	void testSetPhone(String phone, String message) throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThatThrownBy(() -> contact.setPhone(phone))
		.isNotNull()
		.hasMessage(message);
	}
	
	// test address with bad input values
	@CsvSource ({
		", address must not be null",
		"' ', address must not be blank",
		"123 Maple Dr. 123 Maple Dr. 123 Maple Dr., address must be at least 1 and no greater than 30 characters in length"
	})
	@ParameterizedTest
	void testSetAddress(String address, String message) throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThatThrownBy(() -> contact.setAddress(address))
		.isNotNull()
		.hasMessage(message);
	}
}
