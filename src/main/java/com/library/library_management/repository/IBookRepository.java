package com.library.library_management.repository;

import com.library.library_management.model.Book;
import com.library.library_management.model.BookProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

//            List<Book> findByBookName(String name);
//            @Query("from Book b inner join b.bookProfile bp where b.bookName = ?1 and bp.edition =?2")
//            List<Book> findByNameAndEdition(String name,String edition);
//            @Query("from Book b inner join b.bookProfile bp where bp.genre =?1")
//            List<Book> findByGenre(String genre);
//            @Query("from Book b inner join b.bookProfile bp where bp.price =?1")
//            List<Book> findByPrice(Double price);
//            @Query("from Book b inner join b.bookProfile bp where bp.pages =?1")
//            List<Book> findByPages(Long pages);
//            @Query("from Book b inner join b.User bu where bu.user_id =?1")
//            List<Book> findByUserId(Long userId);

}
