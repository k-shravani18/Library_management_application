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

    private String name;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    @JoinColumn(name = "member_id")
    private IssueBook issueBook;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    @JoinColumn(name = "member_id")
    private ReturnBook returnBook;

    // Getters and setters

}
