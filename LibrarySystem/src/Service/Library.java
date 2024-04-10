package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import Exception.BookNotAvailableException;
import Model.Book;

public class Library {
	
	private ArrayList<Book> books;
    private LinkedList<String> waitingList;
    private Vector<String> members;
    private Stack<Book> returnedBooks;
    private HashSet<String> membersSet;
    private LinkedHashSet<String> borrowedBooks;
    private TreeSet<String> sortedBookTitles;
    private HashMap<Integer, Book> bookMap;
    private LinkedHashMap<Integer, String> bookCheckoutMap;
    private TreeMap<Integer, Book> sortedBookMap;  
    
    public Library() {
    	books = new ArrayList<>();
    	waitingList = new LinkedList<>();
    	members = new Vector<>();
    	returnedBooks = new Stack<>();
    	membersSet = new HashSet<>();
    	borrowedBooks = new LinkedHashSet<>();
    	sortedBookTitles = new TreeSet<>();
    	bookMap = new HashMap<>();
    	bookCheckoutMap = new LinkedHashMap<>();
    	sortedBookMap = new TreeMap<>();
    }
    
    public void addBook(Book book) {
    	books.add(book);
    	sortedBookTitles.add(book.getTitle());
    	bookMap.put(book.getBook_id(), book);
    	sortedBookMap.put(book.getBook_id(), book);
    	
    }
    
    public void registerMember(String name) {
    	if(!membersSet.contains(name)) {
    		members.add(name);
    		membersSet.add(name);
    	}else {
    		System.out.println("Member allready exist !");
    	}
    }
    
    public void checkoutBook(Integer bookId , String memberName) {
    	try {
			if(membersSet.contains(memberName)) {
				Book book = bookMap.get(bookId);
				if(book == null) {
					throw new BookNotAvailableException("With id "+bookId +" is not Available");
				}
				books.remove(book);
				borrowedBooks.add(book.getTitle());
				bookCheckoutMap.put(bookId, memberName);
				System.out.println(memberName +" check out " + book.getTitle());
				
				
			}else {
				System.out.println("Registration first !");
			}
		} catch (BookNotAvailableException e) {
			System.out.println(e.getMessage());
			waitingList.add(memberName);
		}
    	
    }
    
    public void returnBook(int bookId) {
        Book book = bookMap.get(bookId);
        if (book != null) {
            books.add(book);
            borrowedBooks.remove(book.getTitle());
            returnedBooks.push(book);
            bookCheckoutMap.remove(bookId);
            System.out.println("Book " + book.getTitle() + " returned.");
            if (!waitingList.isEmpty()) {
                String nextInLine = waitingList.poll();
                System.out.println(nextInLine + " can now check out a book.");
            }
        }
    }
    
 // Display all books in the library
    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Display borrowed books
    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (String title : borrowedBooks) {
            System.out.println(title);
        }
    }

    // Display waiting list
    public void displayWaitingList() {
        System.out.println("Waiting List:");
        for (String member : waitingList) {
            System.out.println(member);
        }
    }

    // Display members
    public void displayMembers() {
        System.out.println("Library Members:");
        for (String member : members) {
            System.out.println(member);
        }
    }

}
