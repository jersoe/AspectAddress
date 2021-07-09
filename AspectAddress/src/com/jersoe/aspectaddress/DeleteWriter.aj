package com.jersoe.aspectaddress;

// Writes contact data to a file when a contact is deleted.
public aspect DeleteWriter {
	before(): execution (* Controller.deleteContact(int)) {
		Controller c = (Controller) thisJoinPoint.getThis();

		Contact oldContact = c.getModel().getContact((int) thisJoinPoint.getArgs()[0]);

		Controller.logger("Record Deleted: " + oldContact.getFirstName() + " " + oldContact.getLastName() + " "
				+ oldContact.getStreet() + " " + oldContact.getCity() + " " + oldContact.getState() + " "
				+ oldContact.getZip() + " " + oldContact.getPhone());
	}
}
