package repositories;

import data.interfaces.IDB;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private IDB db;

    public BookRepository(IDB db) {
        this.db = db;
    }


    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM librarydb ORDER BY id ASC";
        try (Connection conn = db.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("quantity")
                ));
            }
        }
        return books;
    }

    public void addNewBook(String title, String author, int year, int quantity) throws SQLException {
        String query = "INSERT INTO librarydb (title, author, year, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, year);
            pstmt.setInt(4, quantity);
            pstmt.executeUpdate();
        }
    }

    public void deleteBook(String bookTitle) throws SQLException {
        String query = "DELETE FROM librarydb WHERE title = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, bookTitle);
            pstmt.executeUpdate();
        }
    }

    public void takeBook(String firstname, String lastname,String bookTitle) throws SQLException {
        String chackQuery = "SELECT quantity FROM librarydb WHERE title = ?";
        String updateQuery = "UPDATE librarydb SET quantity = quantity - 1 WHERE title = ? AND quantity > 0";
        String insertUserQuery = " INSERT INTO user (name, surname, booktitle) VALUES (?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(chackQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertUserQuery)) {

            checkStmt.setString(1, bookTitle);
            ResultSet rs = checkStmt.executeQuery();

            if(rs.next() && rs.getInt("quantity") > 0) {
                updateStmt.setString(1, bookTitle);
                updateStmt.executeUpdate();

                insertStmt.setString(1, firstname);
                insertStmt.setString(2, lastname);
                insertStmt.setString(3, bookTitle);
                insertStmt.executeUpdate();

            }else{
                System.out.println("Book is not available");
            }
        }

    }

    public void returnBook(String bookTitle, String firstname, String lastname) throws SQLException {
        String checkQuery = "SELECT * FROM user WHERE name = ? AND surname = ? AND booktitle = ?";
        String updateQuery = "UPDATE librarydb SET quantity = quantity + 1 WHERE title = ? AND quantity > 0";
        String deleteUserQuery = "DELETE FROM user WHERE name = ? AND surname = ? AND booktitle = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteUserQuery)) {
            checkStmt.setString(1, firstname);
            checkStmt.setString(2, lastname);
            checkStmt.setString(3, bookTitle);
            ResultSet rs = checkStmt.executeQuery();

            if(rs.next()){
                updateStmt.setString(1, bookTitle);
                updateStmt.executeUpdate();

                deleteStmt.setString(1, firstname);
                deleteStmt.setString(2, lastname);
                deleteStmt.setString(3, bookTitle);
                deleteStmt.executeUpdate();
            }else {
                System.out.println("You have not borrowed this book");
            }



        }
    }
}

