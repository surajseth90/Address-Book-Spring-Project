package com.bridgelabz.addressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	private List<AddressBookData> addressBookList = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookDataByID(int id) {
		return addressBookList.stream()
				.filter(addId->addId.getId()==id)
				.findFirst()
				.orElseThrow(()->new AddressBookException("Address Book is not Available"));
	}

	@Override
	public AddressBookData addAddressBookData(AddressBookDTO dto) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addressBookList.size() + 1, dto);
		addressBookList.add(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int id, AddressBookDTO dto) {
		AddressBookData addressBookData = this.getAddressBookDataByID(id);
		addressBookData.setName(dto.getName());
		addressBookData.setAddress(dto.getAddress());
		addressBookList.set(id - 1, addressBookData);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int id) {
		addressBookList.remove(id);
	}

}
