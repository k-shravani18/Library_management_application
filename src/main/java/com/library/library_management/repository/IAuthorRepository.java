package com.library.library_management.repository;

import com.library.library_management.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
