package com.library.library_management.service;

import com.library.library_management.model.Address;
import com.library.library_management.model.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher addPublisher(Publisher publisher, Address address);
    Publisher updatePublisher(Publisher publisher,Address address);
    void deletePublisher(Publisher  publisher);
    Publisher getById(Long publisher_id);
    List<Publisher>getAll();


    //custom operations
//    List<Book> getByName(String name);
//    List<Book> getByNameAndEdition(String name,String edition);
//    List<Book> getByGenre(String genre);
//    List<Book> getByPrice(Double price);
//    List<Book> getByPages(Long pages);
//    List<Book> getByUserId(Long user_id);
}