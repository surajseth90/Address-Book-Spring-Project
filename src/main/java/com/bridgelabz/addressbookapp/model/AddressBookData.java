package com.bridgelabz.addressbookapp.model;

import javax.validation.constraints.NotEmpty;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import lombok.Data;

@Data
public class AddressBookData {

	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;

	public AddressBookData() {
	
	}

	public AddressBookData(int id, AddressBookDTO addressBookDTO) {
		super();
		this.id = id;
		this.name = addressBookDTO.getName();
		this.address = addressBookDTO.getAddress();
		this.city = addressBookDTO.getCity();
		this.state = addressBookDTO.getState();
		this.zip = addressBookDTO.getZip();
		this.phoneNumber = addressBookDTO.getPhoneNumber();
	}

}
