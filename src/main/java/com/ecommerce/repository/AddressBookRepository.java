package com.ecommerce.repository;

import com.ecommerce.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    List<AddressBook> findByUserId(Long userId);
}
