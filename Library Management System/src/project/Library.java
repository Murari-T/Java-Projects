package project;

import java.util.HashMap;
import java.util.Scanner;

public class Library implements LibraryOperations{
	Scanner sc=new Scanner(System.in);
	
	private HashMap<Book,Integer> books=new HashMap<>();
	
	String title;

	@Override
	public void addBook() {
		
		System.out.print("Book Title : ");
		String title=sc.nextLine();
		System.out.print("Book Author : ");
		String author=sc.nextLine();
		System.out.print("Book ISBN : ");
		String ISBN=sc.nextLine();
		
		Book newBook=new Book(title,author,ISBN);	//create book object
				
		//book is present it will increment or add new book
		books.put(newBook, books.getOrDefault(newBook, 0)+1);	
	}

	@Override
	public void displayBooks() {
		for(Book book:books.keySet())
		{
			System.out.println("+-----------------------------------------------+");
			System.out.println(book+" : "+books.get(book)+"copies ");
			System.out.println("+-----------------------------------------------+");
		}
		
	}

	@Override
	public boolean borrowBook() {

		System.out.print("Book Title : ");
		title=sc.nextLine();
		System.out.print("Book Author : ");
		String author=sc.nextLine();
		System.out.print("Book ISBN : ");
		String ISBN=sc.nextLine();
		
		for(Book book:books.keySet())
		{
			if(book.getTitle().equalsIgnoreCase(title)
					&& book.getAuthor().equalsIgnoreCase(author)
					&& book.getISBN().equals(ISBN) && book.isAvailable())
			{
				if(books.get(book)<=0)
				{
					book.setAvailable(false);
					return false;
				}
				books.put(book, books.get(book)-1);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean returnBook() {

		System.out.print("Book Title : ");
		title=sc.nextLine();
		System.out.print("Book Author : ");
		String author=sc.nextLine();
		System.out.print("Book ISBN : ");
		String ISBN=sc.nextLine();
		
		for(Book book:books.keySet())
		{
			if(book.getTitle().equalsIgnoreCase(title)
					&& book.getAuthor().equalsIgnoreCase(author)
					&& book.getISBN().equals(ISBN) && book.isAvailable())
			{
				books.put(book, books.get(book)+1);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean searchBook() {

		System.out.print("Book Title : ");
		title=sc.nextLine();
		System.out.print("Book Author : ");
		String author=sc.nextLine();
		System.out.print("Book ISBN : ");
		String ISBN=sc.nextLine();
		
		for(Book book:books.keySet())
		{
			if(book.getTitle().equalsIgnoreCase(title)
					&& book.getAuthor().equalsIgnoreCase(author)
					&& book.getISBN().equals(ISBN) && book.isAvailable())
			{
				if((books.get(book)>0))
				{
					return true;
				}
			}
		}
		return false;
		
	}
	
	

}