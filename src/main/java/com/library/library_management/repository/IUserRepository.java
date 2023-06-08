package com.library.library_management.repository;

import com.library.library_management.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Member,Long> {
//        List<User> findByFirstName(String fName);
//        List<User> findByLastName(String lName);
//        List<User> findByCity(String city);
//        List<User> findByStreet(String street);
//        List<User> findByState(String state);
//        List<User> findByZipcode(String zipcode);
//        User findByFnameAndLname(String fName, String lName);
}
