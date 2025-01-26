package project;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		Library library = new Library();	//create object of library
		String userName;
		User user;		
		do
		{
			System.out.println(" 1.Add Book \n 2.Display Books \n 3.Borrow Book \n 4.Return Book \n 5.Search Book ");
			int no=sc.nextInt();
			sc.nextLine();
			
			switch(no)
			{
			case 1:
				System.out.println("	Add Book");
				library.addBook();
				break;
			case 2:
				System.out.println("	Display Books");
				library.displayBooks();
				break;
			case 3:
				System.out.println("	Borrow Book ");
				System.out.print("Enter User name : ");
				userName=sc.nextLine();
				user=new User(userName);
				user.borrowBook(library);
				break;
			case 4:
				System.out.println("	Return Book");
				System.out.print("Enter User name : ");
				userName=sc.nextLine();
				user=new User(userName);
				user.returnBook(library);
				break;
			case 5:
				System.out.println("    Search Book ");
				System.out.println((library.searchBook()?"Book Available":"Book Not Available"));
				break;
			default:
				System.out.println("Invalid choice ");
				break;
			}
			System.out.print("Press . to end ");
			System.out.println();
		}while(!sc.nextLine().equals("."));
		System.out.println("Program ended");
		sc.close();
	}

}