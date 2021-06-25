package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-za-z/s]{2,}$",message = "Name is Invalid")
	private String name;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String state;
	
	@NotEmpty
	private String zip;
	
	@NotEmpty
	private String phoneNumber;
}
