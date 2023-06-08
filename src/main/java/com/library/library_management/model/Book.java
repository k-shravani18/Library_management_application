package com.library.library_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_profile_id")
    private BookProfile bookProfile;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member user;

    public BookProfile getBookProfile() {
        return bookProfile;
    }

    public void setBookProfile(BookProfile bookProfile) {
        this.bookProfile = bookProfile;
    }
}

