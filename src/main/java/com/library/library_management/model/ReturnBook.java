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
@Table(name = "returnBook")
public class ReturnBook {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book")
    private List<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long returnBookId;

    private Date returnDate;
    private Integer daysElapsed;
    private Integer fine;
}
