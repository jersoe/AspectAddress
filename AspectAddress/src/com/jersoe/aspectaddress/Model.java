package com.jersoe.aspectaddress;

import java.util.ArrayList;
import java.util.Collections;

//Represents the model in MVC
public class Model {
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	//Constructor
	public Model() {
		this.initializeFakeData();
	}

	//Load fake data
	public void initializeFakeData() {
		this.contacts.add(new Contact(1, "Bill", "Smith", "123 Main St", "Coolsville", "MD", "20876", "301-555-1234"));
		this.contacts.add(new Contact(2, "Sally", "Jones", "1 Here Dr", "Rockville", "MD", "1111", "240-888-3400"));
		this.contacts.add(new Contact(3, "Mohamad", "Smith", "333 Elm St", "Largo", "MD", "21726", "240-777-9999"));
	}

	//Returns a sorted ArrayList of contacts.
	public ArrayList<Contact> getContacts() {
		Collections.sort(this.contacts);
		return contacts;
	}

	//Returns a single contact.
	public Contact getContact(int id) {
		for (Contact c : this.contacts) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	//Updates a contact
	public void updateContact(int id, String firstName, String lastName, String street, String city, String state,
			String zip, String phone) {

		Contact updatedContact = new Contact(id, firstName, lastName, street, city, state, zip, phone);

		this.contacts.remove(this.contacts.indexOf(updatedContact));
		this.contacts.add(updatedContact);
	}

	//Adds a new contact
	public void addContact(String firstName, String lastName, String street, String city, String state, String zip,
			String phone) {
		this.contacts.add(new Contact(this.getNextId(), firstName, lastName, street, city, state, zip, phone));
	}

	//Deletes a contact
	public void deleteContact(int id) {
		Contact toBeDeletedContact = new Contact(id);

		this.contacts.remove(this.contacts.indexOf(toBeDeletedContact));
	}

	//Finds the next available id.
	private int getNextId() {
		int nextId = 0;
		for (Contact c : this.contacts) {
			if (c.getId() >= nextId) {
				nextId = c.getId() + 1;
			}
		}
		return nextId;
	}
}
