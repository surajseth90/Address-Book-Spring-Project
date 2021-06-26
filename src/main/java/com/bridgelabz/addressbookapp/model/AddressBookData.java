package com.bridgelabz.addressbookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "address_book")
public class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	public AddressBookData() {

	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
		super();
		this.name = addressBookDTO.getName();
		this.address = addressBookDTO.getAddress();
		this.city = addressBookDTO.getCity();
		this.state = addressBookDTO.getState();
		this.zip = addressBookDTO.getZip();
		this.phoneNumber = addressBookDTO.getPhoneNumber();
	}

}
