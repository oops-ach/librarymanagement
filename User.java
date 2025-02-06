package models;

public class User {
	private int id;
	private String name;
	private String surname;
	private String bookTitle;

	public User(int id, String name, String surname, String bookTitle) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.bookTitle = bookTitle;
	}

	public int getId() { return id; }
	public String getName() { return name; }
	public String getSurname() { return surname; }
	public String getBookTitle() { return bookTitle; }

	@Override
	public String toString() {
		return "User [ID: " + id +
				", Name: " + name +
				", Surname: " + surname +
				", Book Title: " + bookTitle +
				"]";
	}
}
