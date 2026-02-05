package com.example.litearula.repository;

import com.example.litearula.models.Author;
import com.example.litearula.models.AuthorDatas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findByNameContainingIgnoreCase(String name);

    Optional<Author> findById();
}
