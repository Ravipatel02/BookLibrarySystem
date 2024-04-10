package RunnerClass;

import Model.Book;
import Service.Library;

public class Main {
	
	public static void main(String[] args) {
        // Create a library object
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book(101, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(102, "1984", "George Orwell"));
        library.addBook(new Book(103, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(104, "Pride and Prejudice", "Jane Austen"));

        // Register some members
        library.registerMember("Alice");
        library.registerMember("Bob");
        library.registerMember("Charlie");

        // Checkout and return books
        library.checkoutBook(101, "Alice");
        library.checkoutBook(102, "ravi");
        library.returnBook(101);
        library.returnBook(102);

        // Display books, borrowed books, waiting list, and members
        library.displayBooks();
        library.displayBorrowedBooks();
        library.displayWaitingList();
        library.displayMembers();
    }

}
