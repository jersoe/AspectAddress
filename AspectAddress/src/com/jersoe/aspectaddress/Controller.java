package com.jersoe.aspectaddress;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Represents the controller in MVC
public class Controller {

	private View v;
	private Model m = new Model();

	//Constructor
	public Controller() {
		Controller c = this;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v = new View(c, m.getContacts());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Returns the model
	protected Model getModel() {
		return this.m;
	}

	//Updates a contact
	protected void updateContact(int id, String firstName, String lastName, String street, String city, String state,
			String zip, String phone) {
		this.m.updateContact(id, firstName, lastName, street, city, state, zip, phone);
		this.v.setContacts(this.m.getContacts());
	}

	//Deletes a contact
	protected void deleteContact(int id) {
		this.m.deleteContact(id);
		this.v.setContacts(this.m.getContacts());
	}

	//Adds a contact
	protected void addContact(String firstName, String lastName, String street, String city, String state, String zip,
			String phone) {
		this.m.addContact(firstName, lastName, street, city, state, zip, phone);
		this.v.setContacts(this.m.getContacts());
	}

	//Starting point of program
	public static void main(String[] args) {
		new Controller();
	}

	//Static method to log updating/deleting
	public static void logger(String line) {
		try (FileWriter fw = new FileWriter("log.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(line);
		} catch (IOException e) {
			System.out.println("Cannot write to log!");
		}
	}
}
