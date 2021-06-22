package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getAddressBook() {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, new AddressBookDTO("Suraj", "Datia"));
		ResponseDTO dto = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable("id") int id) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(id, new AddressBookDTO("Suraj", "Datia"));
		ResponseDTO dto = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1, addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Post Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updatedAddressBook(@PathVariable("id") int id,
			@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = null;
		ResponseDTO dto = new ResponseDTO("update Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id) {
		ResponseDTO dto = new ResponseDTO("Delete Call Success", id);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);	}
}
