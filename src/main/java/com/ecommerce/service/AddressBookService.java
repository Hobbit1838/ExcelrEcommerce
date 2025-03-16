package com.ecommerce.service;

import com.ecommerce.model.AddressBook;
import com.ecommerce.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookService {
    private final AddressBookRepository addressBookRepository;

    public AddressBookService(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    public List<AddressBook> getUserAddresses(Long userId) {
        return addressBookRepository.findByUserId(userId);
    }

    public AddressBook addAddress(AddressBook address) {
        return addressBookRepository.save(address);
    }

    public void removeAddress(Long id) {
        addressBookRepository.deleteById(id);
    }
}
