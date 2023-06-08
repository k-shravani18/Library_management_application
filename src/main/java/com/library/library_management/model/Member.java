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
@Table(name = "\"member\"")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String firstName;
    private String lastName;
    private String age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "member_address",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Book> memberBooks;

    // Getters and setters

}
