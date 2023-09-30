package com.example.addressbookapp.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressBookDto {
    @NotEmpty(message=" cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "FirstName name Invalid")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "LastName name Invalid")
    @NotEmpty(message = " should be not empty")
    public String lastName;

    @NotBlank(message = "note cannot be empty")
    public String mobileNumber;

    @Pattern(regexp =("[a-z0-9]+@[a-z.]+[a-z]$"), message = "emailId name Invalid")
    @NotEmpty(message = " should be not empty")
    public String emailId;


    @NotEmpty(message = " should be not empty")
    public String zipCode;
    @NotEmpty(message = " should be not empty")
    public String city;






}
