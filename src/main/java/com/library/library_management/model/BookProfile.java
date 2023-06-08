package com.library.library_management.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_profile")
public class BookProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookProfileId;

    private String author;
    private String edition;
    private String category;
    private int pages;
    private double price;
    private String publisher;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bookProfile")
    @JoinColumn(name = "book_profile_id")
    private Book book;



    // Getters and setters
}

