package com.decipher.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
	/*@Id*/
	private String userName;
	private String address;
	private String rollNumber;
	private String phone;

	/*public Employee() {
	}

	public Employee(String userName, String address, String rollNumber, String phone) {
		this.userName = userName;
		this.address = address;
		this.rollNumber = rollNumber;
		this.phone = phone;
	}*/


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", address=" + address + ", rollNumber=" + rollNumber + ", phone="
				+ phone + "]";
	}

}
