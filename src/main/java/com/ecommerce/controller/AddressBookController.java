package com.ecommerce.controller;

import com.ecommerce.model.AddressBook;
import com.ecommerce.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/address-book")
public class AddressBookController {
    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AddressBook>> getUserAddresses(@PathVariable Long userId) {
        return ResponseEntity.ok(addressBookService.getUserAddresses(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addAddress(@RequestBody AddressBook address) {
        return ResponseEntity.ok(addressBookService.addAddress(address));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeAddress(@PathVariable Long id) {
        addressBookService.removeAddress(id);
        return ResponseEntity.ok("Address removed successfully");
    }
}
