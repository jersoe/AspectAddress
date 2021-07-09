package com.jersoe.aspectaddress;

//Writes previous data to a file when a contact is updated.
public aspect UpdateWriter {
	before(): execution (* Controller.updateContact(int, String, String, String, String, String, String, String)) {
		Controller c = (Controller) thisJoinPoint.getThis();

		Contact oldContact = c.getModel().getContact((int) thisJoinPoint.getArgs()[0]);

		Controller.logger("Record Updated: " + oldContact.getFirstName() + " " + oldContact.getLastName() + " "
				+ oldContact.getStreet() + " " + oldContact.getCity() + " " + oldContact.getState() + " "
				+ oldContact.getZip() + " " + oldContact.getPhone());
	}
}
