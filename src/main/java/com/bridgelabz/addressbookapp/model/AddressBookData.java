package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import lombok.Data;

@Data
public class AddressBookData {

	private int id;
	private String name;
	private String address;

	public AddressBookData(int id, AddressBookDTO addressBookDTO) {
		super();
		this.id = id;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;

	}

}
