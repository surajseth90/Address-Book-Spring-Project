package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bridgelabz.addressbookapp.service.IAddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookController;

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getAddressBook() {
		List<AddressBookData> addressBookList = null;
		addressBookList = addressBookController.getAddressBookData();
		ResponseDTO dto = new ResponseDTO("Get Call Success", addressBookList);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable("id") int id) {
		AddressBookData addressBookData = null;
		addressBookData = addressBookController.getAddressBookDataByID(id);
		ResponseDTO dto = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookController.addAddressBookData(addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Post Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updatedAddressBook(@Valid @PathVariable("id") int id,
			@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookController.updateAddressBookData(id, addressBookDTO);
		ResponseDTO dto = new ResponseDTO("update Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id) {
		addressBookController.deleteAddressBookData(id);
		ResponseDTO dto = new ResponseDTO("Delete Call Success", id);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}
}
