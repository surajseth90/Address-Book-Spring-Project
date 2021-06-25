package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-za-z/s]{2,}$",message = "Name is Invalid")
	public String name;
	
	@NotEmpty
	public String address;

	public AddressBookDTO() {

	}

	public AddressBookDTO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
}
