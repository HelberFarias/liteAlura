package com.example.litearula;

import com.example.litearula.external.GutendexClient;
import com.example.litearula.models.*;
import com.example.litearula.repository.AuthorRepository;
import com.example.litearula.repository.BookRepository;
import com.example.litearula.service.DataConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    Scanner input = new Scanner(System.in);
    DataConverter converter;
    GutendexClient client;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private List<Book> books;


    public Principal(DataConverter converter, GutendexClient client, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.converter = converter;
        this.client = client;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {
        System.out.println(
                """
                --------------------------
                -- Welcome to LiteArula --
                --------------------------
                """);
        int choice = -1;
        while (choice != 0) {
            var menu = (
                    """
                            1 - Search book
                            2 - Show registered books
                            3 - Show authors
                            4 - Show living authors
                            5 - Show books by language
                            0 - Exit program
                            """);

            System.out.println(menu);
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    searchBooks();
                    break;
                case 2:
                    showRegisteredBooks();
                    break;
                case 3:
                    showAuthors();
                    break;
                case 4:
                    showLivingAuthors();
                    break;
                case 5:
                    showBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }

    }

    private void searchBooks() {
        final String baseUrl = "https://gutendex.com/books?";
        final String searchParams = "search=";
        final String userInput;
        System.out.println("Please enter the book you want to search: ");
        userInput = input.nextLine().toLowerCase().replace(" ", "%20");
        var json = client.getDataApi(baseUrl + searchParams + userInput);
        var dataContainer = converter.parseJson(json, ContainerBook.class);
        if (dataContainer.results().isEmpty()) {
            System.out.println("No books found!");
        } else {
            var bookData = dataContainer.results().get(0);
            int apiId = bookData.apiId();
            String title = bookData.title();
            double downloadCount = bookData.downloadCount();

            String author = bookData.authors().isEmpty()
                    ? "Unknown"
                    : bookData.authors().get(0).name();

            String language = bookData.languages().isEmpty()
                    ? "N/A"
                    : bookData.languages().get(0);

            var authorDatas = bookData.authors();
            if(!authorDatas.isEmpty()) {
                String nameAuthor = authorDatas.get(0).name();
                Author finalAuthor = null;
                Optional<Author> authorFind = authorRepository.findByNameContainingIgnoreCase(nameAuthor);
                if (authorFind.isPresent()) {
                    finalAuthor = authorFind.get();
                } else {
                    var add = authorDatas.get(0);
                    Author createdAuthor = new Author();
                    createdAuthor.setName(nameAuthor);
                    createdAuthor.setBirthYear(add.birthYear());
                    createdAuthor.setDeathYear(add.deathYear());
                    finalAuthor = authorRepository.save(createdAuthor);
                }
                Book book = new Book(apiId, title, language, downloadCount);
                book.setAuthor(finalAuthor);
                bookRepository.save(book);
                System.out.println(book);
            }
        }
    }

    private void showRegisteredBooks() {
        books = bookRepository.findAll();
        books.stream().forEach(System.out::println);
    }

    private void showAuthors() {
        authorRepository.findAll()
                .stream()
                .forEach(System.out::println);
    }

    private void showLivingAuthors() {
         List<Author> aliveAuthors = authorRepository.findAll()
                .stream()
                .filter(a -> a.getDeathYear() == null)
                .collect(Collectors.toList());
         aliveAuthors.stream().forEach(System.out::println);

    }

    private void showBooksByLanguage() {
        System.out.println("""
                Please, enter de language: 
                -- PT --
                -- EN --
                -- FR --
                -- FI --
                """);
        String choiceLanguages = input.nextLine().toLowerCase();
        List<Book> languageBook = bookRepository.findByLanguagesContainingIgnoreCase(choiceLanguages);
        languageBook.forEach(System.out::println);
    }
}
