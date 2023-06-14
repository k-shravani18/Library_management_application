package com.library.library_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address_table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;


    private String location;
    private String phoneNumber;

    @ManyToMany(mappedBy = "addresses")
    private List<Member> members;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}

