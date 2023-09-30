package com.example.addressbookapp.service;
import com.example.addressbookapp.Dto.AddressBookDto;
import com.example.addressbookapp.Repo.AddressBookAppRepo;
import com.example.addressbookapp.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookService {
    private List<User> bookList =new ArrayList<>();
    @Autowired
    AddressBookAppRepo addressbookapprepo;
//    public User addAddressBookDto(AddressBookDto addressBookDto){
//        User bookobject = new User(addressBookDto);
//        bookList.add(bookobject);
//        return addressbookapprepo.save(bookobject);
//    }
//
//    public User getBook(int id){
//        return addressbookapprepo.findById(id).orElse(null);
//    }
//
//    public List<User> getAllBook(){
//        List<User> booklist = addressbookapprepo.findAll();
//        return booklist;
//    }
//
//    public User updateBook(@NotNull AddressBookDto book, int id){
//        User bookobject = new User(book);
//        bookobject.setId(id);
//        return addressbookapprepo.save(bookobject);
//    }
//    public User deleteBook(int id){
//        addressbookapprepo.deleteById(id);
//        return null;
//    }
 //   private List<User> addressBooklist=new ArrayList<>();
//
//


    public User addAddressBookDto(AddressBookDto addressBookDto) {
        User addressBook = new User(addressBookDto);
        bookList.add(addressBook);
        return addressbookapprepo.save(addressBook);
    }

    public User getAddressBook(int id){
        return addressbookapprepo.findById(id).orElse(null);
    }

    public String deleteAddressBook(int id) {
        addressbookapprepo.deleteById(id);
        return "deleted successfully";
    }

    public User updateAddressBook(@NotNull AddressBookDto ab, int id){
        User abobject = new User(ab);
        abobject.setId(id);
        return addressbookapprepo.save(abobject);
    }
    public List<User> getAllAddressBook() {
        return addressbookapprepo.findAll();
    }

    public List<User> getUserByCity(String city){
        return addressbookapprepo.findByCity(city);
    }
}
