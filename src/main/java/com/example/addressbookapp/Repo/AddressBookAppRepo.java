package com.example.addressbookapp.Repo;

import com.example.addressbookapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBookAppRepo extends JpaRepository<User, Integer> {
    List<User> findByCity(String City);


}
