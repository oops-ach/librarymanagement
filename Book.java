package models;

public class Book {
	private int id;
	private String title;
	private String author;
	private int year;
	private int quantity;

	public Book(int id, String title, String author, int year, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.quantity = quantity;
	}

	public int getId() { return id; }
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public int getYear() { return year; }
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }

	@Override
	public String toString() {
		return "Book [ID: " + id +
				", Title: " + title +
				", Author: " + author +
				", Year: " + year +
				", Quantity: " + quantity +
				"]";
	}
}
