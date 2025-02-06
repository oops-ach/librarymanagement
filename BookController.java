package controllers;

import models.Book;
import repositories.BookRepository;

import java.sql.SQLException;
import java.util.List;

public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


	public void showAllBooks() {
        try {
            List<Book> books = bookRepository.getAllBooks();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching books: " + e.getMessage());
        }
    }

    public void addNewBook(String title, String author, int year, int quantity) {
        try {
            bookRepository.addNewBook(title, author, year, quantity);
            System.out.println("New book added successfully!");
        } catch (SQLException e) {
            System.out.println("Error while adding new book: " + e.getMessage());
        }
    }

    public void deleteBook(String bookTitle) {
        try {
            bookRepository.deleteBook(bookTitle);
            System.out.println("Book deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error while deleting book: " + e.getMessage());
        }
    }

    public void takeBook(String firstname, String lastname, String bookTitle) {
        try {
            bookRepository.takeBook(firstname,  lastname, bookTitle);
            System.out.println("Book taken successfully!");
        } catch (SQLException e) {
            System.out.println("Error while taking book: " + e.getMessage());
        }
    }

    public void returnBook(String firstname, String lastname, String bookTitle) {
        try {
            bookRepository.returnBook(firstname, lastname, bookTitle);
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            System.out.println("Error while returning book: " + e.getMessage());
        }
    }
}

