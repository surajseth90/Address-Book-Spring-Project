package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbookapp.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
	@Query(value = "SELECT * FROM address_book WHERE name LIKE ':string%';", nativeQuery = true)
	public AddressBookData findNameByStartingString(String string);

}
