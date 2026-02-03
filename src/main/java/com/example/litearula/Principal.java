package com.example.litearula;

import com.example.litearula.models.Author;
import com.example.litearula.models.Book;

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
