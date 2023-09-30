package com.example.addressbookapp.controller;

import com.example.addressbookapp.Dto.AddressBookDto;
import com.example.addressbookapp.Dto.ResponseDto;
import com.example.addressbookapp.model.User;
import com.example.addressbookapp.service.AddressBookService;
import com.example.addressbookapp.util.Token;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;
    @Autowired
    Token token;


//
//    @PostMapping("/addAddressBookDto")
//    public ResponseEntity<ResponseDto> addAddressBookDto(@Valid @RequestBody AddressBookDto addressBookDto){
//        User addressBook=addressBookService.addAddressBookDto(addressBookDto);
//        ResponseDto responseDto=new ResponseDto("new User added successfully",addressBook);
//        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return response;
//   }
//    @GetMapping("/greetById/{id}")
//    public ResponseEntity<ResponseDto> greetById(@PathVariable int id) {
//        User addressBook=addressBookService.getBook(id);
//        ResponseDto responseDto=new ResponseDto("new User get successfully",addressBook);
//        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return response;
//    }
//    @DeleteMapping("/deleteById/{id}")
//    public ResponseEntity<ResponseDto> deleteById(@Valid @PathVariable int id){
//        User addressBook = addressBookService.deleteBook(id);
//        ResponseDto responseDto = new ResponseDto("User deleted successfully",addressBook);
//        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return response;
//    }
//
//    @PutMapping("/updateById/{id}")
//    public ResponseEntity<ResponseDto> updateById(@Valid @PathVariable int id, @RequestBody AddressBookDto addressBookDto)
//    {
//        User addressBook = addressBookService.updateBook(addressBookDto, id);
//        ResponseDto responseDto = new ResponseDto("user  deleted successfully",addressBook);
//        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return response;
//    }
//    @GetMapping("/allBook")
//    public List<User> getAll(){
//        return addressBookService.getAllBook();
//    }
@GetMapping("/allAddressBook")
public List<User> getAll(){
    return addressBookService.getAllAddressBook();
}


    @PostMapping("/addAddressBookDto")
    public ResponseEntity<ResponseDto> addAddressBookDto(@RequestBody AddressBookDto addressBookDto) {
        User addressBook=addressBookService.addAddressBookDto(addressBookDto);
        String token1= token.createToken(addressBook.getId());
        ResponseDto responseDto=new ResponseDto("new addresbook added successfully",addressBook,token1);
        ResponseEntity<ResponseDto> response=new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @GetMapping("/getAddressBook/{token1}")
    public User getAddressBook(@PathVariable String token1) {
        int UserId= token.decodeToken(token1);
        return addressBookService.getAddressBook(UserId);
    }




    @PutMapping("/updateAddressBook/{token1}")
    public ResponseEntity<ResponseDto> updateAddressBook(@Valid @PathVariable String token1 ,@RequestBody AddressBookDto ab){
        int UserId= token.decodeToken(token1);
        User addressBook = addressBookService.updateAddressBook(ab,UserId);
        ResponseDto responseDto = new ResponseDto(" AddressBook updated successfully",addressBook,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }



    @DeleteMapping("/deleteAddressBook/{token1}")
    public String deleteAddressBook(@PathVariable String token1) {
        int UserId= token.decodeToken(token1);
        return addressBookService.deleteAddressBook(UserId);
    }

    @GetMapping("/getUserByCity")
    public List<User> getCityByCity(@RequestParam String city){
        return addressBookService.getUserByCity(city);
    }


}
