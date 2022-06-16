package com.mediscreendiabete.model;

import java.time.LocalDate;

public class Patient {
	
	/** The id. */
    private int patientId;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The birth date. */
    private LocalDate birthDate;

    /** The sex. */
    private String sex;

    /** The address. */
    private String address;

    /** The phone number. */
    private String phone;

	public Patient() {
	}

	public Patient(int patientId, String firstName, String lastName, LocalDate birthDate, String sex, String address,
			String phone) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
