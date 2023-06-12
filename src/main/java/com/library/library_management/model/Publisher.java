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
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;
    private String publisherName;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> Books;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Address> addressList;
}
