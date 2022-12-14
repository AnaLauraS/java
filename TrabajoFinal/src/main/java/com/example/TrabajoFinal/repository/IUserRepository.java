package com.example.TrabajoFinal.repository;

import com.example.TrabajoFinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.name =:name")
    Optional<User> getUserByName(@Param("name") String name);
}
