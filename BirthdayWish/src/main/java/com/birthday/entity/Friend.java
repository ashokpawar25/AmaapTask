package com.birthday.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Friend {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String email;
    
    public Friend() 
    {
		
	}
    
    public Friend(int id, String lastName, String firstName, LocalDate dateOfBirth, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isBirthday() {
        LocalDate today = LocalDate.now();
        return today.getDayOfMonth() == dateOfBirth.getDayOfMonth() && today.getMonth() == dateOfBirth.getMonth();
    }

	@Override
	public String toString() {
		return "Friend [lastName=" + lastName + ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + ", email="
				+ email + "]";
	}
}
