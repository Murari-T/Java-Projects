package project;

import java.util.Objects;

public class Book {
	
	// variables
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;
	
	//constructor
	public Book(String title, String author, String iSBN) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.isAvailable = true;	// set true by default
	}
	
	//Getters & Setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(ISBN, author, title);	// Generate hashCode based on ISBN,author,title
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;	//cast obj to book object
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author)
				 && Objects.equals(title, other.title);	
			
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + "]";
	}

	

}