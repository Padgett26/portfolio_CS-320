///////////////////////////////////
// Project structure and starter code written by Jason Padgett, with tutorial help from:
// Resource:
// Clinton Bush. SNHU. CS320 - Milestone Series - Video 1, 2, 3. https://youtu.be/qgM3dTF3PSI?si=WJNMzqFN7fBd0sDb.
// All other code content and tests written by Jason Padgett
//////////////////////////////////

package org.snhu.cs320.validation;

import java.time.LocalDate;

import org.snhu.cs320.exceptions.ValidationException;

final public class Validation {
	
	// constructor
	private Validation() {}
	
	// not null exception definition and message throw
	public static void validateNotNull(Object input, String label) throws ValidationException {
		if (input == null) {
			throw new ValidationException(label + " must not be null");
		}
	}
	
	// not blank exception definition and message throw
	public static void validateNotBlank(String input, String label) throws ValidationException {
		validateNotNull(input, label);
		if (input.trim().length() < 1) {
			throw new ValidationException(label + " must not be blank");
		}
	}
	
	// length exception definition and message throw
	public static void validateLength(String input, String label, int minLength, int maxLength) throws ValidationException {
		if (input.length() < minLength || input.length() > maxLength) {
			throw new ValidationException(label + " must be at least " + minLength + " and no greater than " + maxLength + " characters in length");
		}
	}
	
	// phone specific length exception definition and message throw
	public static void validatePhoneLength(String input, String label, int reqLength) throws ValidationException {
		if (input.length() < reqLength || input.length() > reqLength) {
			throw new ValidationException(label + " must be " + reqLength + " numbers in length");
		}
	}
	
	// numeric exception definition and message throw
	public static void validateNumeric(String input, String label) throws ValidationException {
		if (input.matches(".*\\D+.*")) {
			throw new ValidationException(label + " must contain only digits");
		}
	}
	
	// it was suggested that this exception will be needed in a future code version
	// future date exception definition and message throw
	public static void validatePresentOrFuture(LocalDate date, String label) throws ValidationException {
		if (date.isBefore(LocalDate.now())) {
			throw new ValidationException(label + " cannot be in the past");
		}
	}
}
