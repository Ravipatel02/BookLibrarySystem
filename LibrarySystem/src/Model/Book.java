package Model;

public class Book {
	
	private int book_id;
	private String title;
	private String authr;
	
	public Book(int book_id, String title, String authr) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.authr = authr;
	}

	public int getBook_id() {
		return book_id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthr() {
		return authr;
	}

	@Override
	public String toString() {
		return "Book {book_id=" + book_id + ", title=" + title + ", authr=" + authr + "}";
	}
	
	
	
	

}
