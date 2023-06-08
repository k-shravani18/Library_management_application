package com.library.library_management.repository;

import com.library.library_management.model.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReturnBookRepository extends JpaRepository<ReturnBook,Long> {
}
