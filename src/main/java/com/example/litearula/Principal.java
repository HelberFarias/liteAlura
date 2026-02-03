package com.example.litearula;

import com.example.litearula.external.GutendexClient;
import com.example.litearula.models.Author;
import com.example.litearula.models.Book;
import com.example.litearula.service.DataConverter;

import java.util.Scanner;

public class Principal {
    Scanner input = new Scanner(System.in);

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
        Book book = new Book();
        DataConverter converter = new DataConverter();
        GutendexClient client = new GutendexClient();
        final String baseUrl = "https://gutendex.com/books?";
        final String searchParams = "search=";
        final String userInput;
        System.out.println("Please enter the book you want to search: ");
        userInput = input.nextLine().toLowerCase().replace(" ", "%20");
        var clientJson = client.getDataApi(baseUrl + searchParams + userInput);
        var dataConverter = converter.parseJson(clientJson, Book.class);

    }
    private void showRegisteredBooks() {
    }
    private void showAuthors() {
    }
    private void showLivingAuthors() {
    }
    private void showBooksByLanguage() {
    }
}
