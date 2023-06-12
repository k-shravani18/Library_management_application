package com.library.library_management.repository;

import com.library.library_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.username =?1 and u.password = ?2")
    User findByUnameAndPass(String username , String password);
    User findUserByUsername(String username);
}
