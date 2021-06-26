package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

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
	
	@Pattern(regexp = "^[0-9]{6}",message = "Invalid Zip Code !! Please Enter Valid 6 Digit Number")
	private String zip;
	
	@Pattern(regexp = "^[0-9]{10}",message = "Invalid Phone Number !! Please Enter Valid 10 Digit Number")
	private String phoneNumber;
}
