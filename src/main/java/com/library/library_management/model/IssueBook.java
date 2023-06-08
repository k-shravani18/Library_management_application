package com.library.library_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issueBook")
public class IssueBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueBookId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="bookId")
    private List<Book> books;

    private Date issueDate;
    private Date returnDate;

}
