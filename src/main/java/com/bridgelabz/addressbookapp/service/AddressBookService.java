package com.bridgelabz.addressbookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookDataByID(int id) {
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new AddressBookException("Address Book with id = " + id + " is not exists !!"));
	}

	@Override
	public AddressBookData addAddressBookData(AddressBookDTO dto) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(dto);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int id, AddressBookDTO dto) {
		AddressBookData addressBookData = this.getAddressBookDataByID(id);
		addressBookData.updateAddressBookData(dto);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int id) {
		AddressBookData addressBookData = this.getAddressBookDataByID(id);
		addressBookRepository.delete(addressBookData);
	}

	@Override
	public AddressBookData findNameByStartingString(String s) {
		AddressBookData result = addressBookRepository.findNameByStartingString(s);
//		addressBookRepository.findByNameContainin
		return result;
	}

}
