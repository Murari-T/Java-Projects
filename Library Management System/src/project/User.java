package project;

public class User extends Person{
	
	//constructor
	public User(String name)
	{
		super(name);	//calls super class constructor
	}

	public void borrowBook(Library library)
	{
		System.out.println((library.borrowBook()?getName()+" Borrowed Book "+library.title:"Book not Available"));
	}

	public void returnBook(Library library)
	{
		System.out.println((library.returnBook()?getName()+" Returned Book "+library.title:"Book not Available"));
	}
}