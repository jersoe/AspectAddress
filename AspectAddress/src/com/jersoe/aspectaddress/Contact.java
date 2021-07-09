package com.jersoe.aspectaddress;

//Represents a contact
public class Contact implements Comparable {

	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public Contact(int id, String firstName, String lastName, String street, String city, String state, String zip,
			String phone) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;

	}

	public Contact(int id) {
		this.id = id;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Contact)) {
			return false;
		}

		if (o == this) {
			return true;
		}

		Contact c = (Contact) o;
		if (c.getId() == this.getId()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Contact)) {
			return 0;
		}
		
		if (o == this) {
			return 0;
		}
		
		Contact c = (Contact) o;
		return this.getFirstName().compareTo(c.getFirstName());
	}
}
