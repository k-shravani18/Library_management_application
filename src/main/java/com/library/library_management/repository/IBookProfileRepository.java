package com.library.library_management.repository;

import com.library.library_management.model.BookProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookProfileRepository extends JpaRepository<BookProfile,Long> {
}
