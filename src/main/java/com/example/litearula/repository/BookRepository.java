package com.example.litearula.repository;

import com.example.litearula.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository <Book, Long> {
    List<Book> findAll();
    List<Book> findByLanguagesContainingIgnoreCase (String choiceLanguages);

}
