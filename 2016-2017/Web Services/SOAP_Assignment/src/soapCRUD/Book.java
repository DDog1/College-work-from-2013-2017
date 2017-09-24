package soapCRUD;

public class Book {
	private String bookName;
	private String author;
	private String publishDate;
	private String isbn;
	private String description;
	private double price;
	public Book(String bookName,String author, String publishDate, String isbn, String description, double price){
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.isbn = isbn;
		this.description = description;
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
