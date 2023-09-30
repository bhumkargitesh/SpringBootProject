package com.example.addressbookapp.model;

import com.example.addressbookapp.Dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private  int id;
    private String firstName;
    private  String lastName;
    private String mobileNumber;
    private String zipCode;
    private  String emailId;
    private String city;

    public User(AddressBookDto addressBookDto) {

        this.firstName = addressBookDto.firstName;
        this.lastName =addressBookDto.lastName;
        this.mobileNumber =addressBookDto.mobileNumber;
        this.zipCode =addressBookDto.zipCode;
        this.emailId = addressBookDto.emailId;
        this.city = addressBookDto.city;
    }
}
