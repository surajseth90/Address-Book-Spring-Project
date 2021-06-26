package com.bridgelabz.addressbookapp.service;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataByID(int id);

	AddressBookData addAddressBookData(AddressBookDTO dto);

	AddressBookData updateAddressBookData(int id, AddressBookDTO dto);

	void deleteAddressBookData(int id);
}
