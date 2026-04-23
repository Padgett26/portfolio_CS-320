///////////////////////////////////
// Project structure and starter code written by Jason Padgett, with tutorial help from:
// Resource:
// Clinton Bush. SNHU. CS320 - Milestone Series - Video 1, 2, 3. https://youtu.be/qgM3dTF3PSI?si=WJNMzqFN7fBd0sDb.
// All other code content and tests written by Jason Padgett
//////////////////////////////////

package org.snhu.cs320.contact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	// before each test, clear the in-memory data
	@BeforeEach
	void init() {
		ContactService.getInstance().database.clear();
	}
	
	// test whether instance exists
	@Test
	void testGetInstance() {
		assertThat(ContactService.getInstance()).isNotNull();
	}
	
	// test adding a contact to the hash map database
	@Test
	void testAdd() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		assertThat(ContactService.getInstance().database).containsEntry("1", contact);
	}
	
	// test deleting a database entry
	@Test
	void testDelete() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		assertThat(ContactService.getInstance().delete("1")).isTrue();
		assertThat(ContactService.getInstance().database).doesNotContainEntry("1", contact);
	}
	
	// test updating all non-id fields in the database
	@Test
	void testUpdate() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		Contact updated = new Contact("2", "John", "Smith", "0987654321", "321 Oak Ln.");
		assertThat(ContactService.getInstance().update("1", updated)).isTrue();
		assertThat(ContactService.getInstance().database)
		.extracting("1")
		.hasFieldOrPropertyWithValue("firstName", "John")
		.hasFieldOrPropertyWithValue("lastName", "Smith")
		.hasFieldOrPropertyWithValue("phone", "0987654321")
		.hasFieldOrPropertyWithValue("address", "321 Oak Ln.");
	}
	
	// test updating with a firstName that is too long
	@Test
	void testBadFirstNameLong() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateFirstName("1", "JohnJohnJohn")).isNotNull();
	}
	
	// test updating with a firstName that is null
	@Test
	void testBadFirstNameNull() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateFirstName("1", null)).isNotNull();
	}
	
	// test updating with a firstName that is too short
	@Test
	void testBadFirstNameShort() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateFirstName("1", " ")).isNotNull();
	}
	
	// test updating with a lastName that is too long
	@Test
	void testBadLastNameLong() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateLastName("1", "DoeDoeDoeDoe")).isNotNull();
	}
	
	// test updating with a lastName that is too short
	@Test
	void testBadLastNameNull() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateLastName("1", null)).isNotNull();
	}
	
	// test updating with a lastName that is too short
	@Test
	void testBadLastNameShort() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateLastName("1", " ")).isNotNull();
	}
	
	// test updating with a phone that is too long
	@Test
	void testBadPhoneLong() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updatePhone("1", "1234567890123")).isNotNull();
	}
	
	// test updating with a phone that is null
	@Test
	void testBadPhoneNull() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updatePhone("1", null)).isNotNull();
	}
	
	// test updating with a phone that is too short
	@Test
	void testBadPhoneShort() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updatePhone("1", " ")).isNotNull();
	}
	
	// test updating with a phone that has letters
	@Test
	void testBadPhoneLetters() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updatePhone("1", "123456ABC")).isNotNull();
	}
	
	// test updating with a phone that has non-digit chars
	@Test
	void testBadPhoneChars() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updatePhone("1", "123-456-78")).isNotNull();
	}
	
	// test updating with a phone that has spaces
	@Test
	void testBadPhoneSpaces() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updatePhone("1", "123 456 78")).isNotNull();
	}
	
	// test updating with an address that is too long
	@Test
	void testBadAddressLong() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateAddress("1", "123 Maple Dr.123 Maple Dr.123 Maple Dr.")).isNotNull();
	}
	
	// test updating with an address that is too short
	@Test
	void testBadAddressNull() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateAddress("1", null)).isNotNull();
	}
	
	// test updating with an address that is too short
	@Test
	void testBadAddressShort() throws Exception {
		Contact contact = new Contact("1", "Jane", "Doe", "1234567890", "123 Maple Dr.");
		assertThat(ContactService.getInstance().add(contact)).isTrue();
		
		assertThatThrownBy(() -> ContactService.getInstance().updateAddress("1", " ")).isNotNull();
	}
}
