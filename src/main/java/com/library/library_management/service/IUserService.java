package com.library.library_management.service;

import com.library.library_management.model.Address;
import com.library.library_management.model.Member;

import java.util.List;
public interface IUserService {
    //crud operarions
    void addMember(Member member, Address address);
    String updateUser(Member user);
    String deleteUser(Member user);
    List<Member> getAll();
    Member getById(Long id);
//
//    //custom operations
//    List<User> getByFirstName(String fName);
//    List<User> getByLastName(String lName);
//    List<User> getByCity(String city);
//    List<User> getByStreet(String street);
//    List<User> getByState(String state);
//    List<User> getByZipcode(String zipcode);
//    User getByFnameAndLname(String fName, String lName);


}
