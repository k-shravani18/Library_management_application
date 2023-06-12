package com.library.library_management.repository;

import com.library.library_management.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepository extends JpaRepository<Member,Long> {
//        List<Member> findByFirstName(String fName);
//        List<Member> findByLastName(String lName);
//        List<Member> findByCity(String city);
//        List<Member> findByStreet(String street);
//        List<Member> findByState(String state);
//        List<Member> findByZipcode(String zipcode);

}
