package com.bridgelabz.addressbookapp.controller;

import org.apache.coyote.http11.Http11AprProtocol;
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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<String> getAddressBook() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<String> getAddressBook(@PathVariable("id") int id) {
		return new ResponseEntity<String>("Get Call Success for id" + id, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Post Call Success ", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updatedAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Updated Call Success for : " + addressBookDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("id") int id) {
		return new ResponseEntity<String>("Delete Call Success for id: " + id, HttpStatus.OK);
	}
}
