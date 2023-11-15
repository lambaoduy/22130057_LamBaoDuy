package Lab9_taks2;

import java.util.List;

public abstract class Book {
	String title;
	int numPage;
	int year;
	String authorName;
	double price;

	public Book(String title, int numPage, int year, String authorName, double price) {
		super();
		this.title = title;
		this.numPage = numPage;
		this.year = year;
		this.authorName = authorName;
		this.price = price;
	}

	public String typeBooks() {
		if (this instanceof ReferrenceBook) {
			return "ReferrenceBook";
		} else {
			return "Magazine";
		}
	}

	public boolean published10Year() {
		return 2021 - this.year == 10;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean sameTypeAndAuthor(Book book) {
		return (this.authorName.equals(book.authorName)) && (this.typeBooks().equals(book.typeBooks()) );
	}
	public String getNameMagazine() {
		if (this instanceof Magazine) {
			Magazine mag= (Magazine) this;
			return mag.getName();
		}
		return null;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
