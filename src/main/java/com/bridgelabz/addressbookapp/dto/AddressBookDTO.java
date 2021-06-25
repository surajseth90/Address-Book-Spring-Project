package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressBookDTO {

	public String name;
	public String address;

	public AddressBookDTO() {

	}

	public AddressBookDTO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
}
