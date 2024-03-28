package LibraryManagementSystem;
import java.util.Scanner;

import LibraryManagementSystem.Library;

public class Librarymain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int recordsToInsert=1;
		Library l = new Library();
		System.out.println("Please select an option to perform:\n"
				+"1. Insert min of 5 records into the table dynamically\n"
				+"2. Give all the detailes from the library table\n"
			    +"3. Select the details of all the library books,which is from a specific location \n"
				+"4. Select the details of all the library books which is published after a specific year\n"
			    +"5. Update the library location to a specific location where the bookid is a specific id "
			    +"6. Delete the details of the book with a specific id\n");
		
				
		
			int choice = sc.nextInt();
			switch(choice) {
		    case 1:{
		    	for(int i=0;i<recordsToInsert;i++) {
		    
		    	System.out.println("Insert 1 records into the table dynamically ");
			    System.out.println("Enter the book id : ");
			    l.setBookid(sc.nextInt());
			    System.out.println("Enter the Book name : ");
			    l.setBookname(sc.next());
			    System.out.println("Enter the author : ");
			    l.setAuthor(sc.next());
			    System.out.println("Enter the yearpublish : ");
			    l.setYearpublish(sc.nextInt());
			    System.out.println("Enter the cost");
			    l.setCost(sc.nextInt());
			    System.out.println("Enter the library location");
			    l.setLiblocation(sc.next());
		    	}
		    	
		    	//System.out.println("information" +recordsToInsert+ "inserted");
			    
			    boolean b= l.insertData();
			    
			    if(b==true) {
			    	System.out.println("Data inserted");
			    }
				else {
					System.out.println("Data insertion failed");
				}
			    break;
			    }
		    case 2 :{
		    	System.out.println("Give all details from the librarytable ");
		    	l.fetchAllData();
				break;
		    }
		    
		     case 3:{
		    	System.out.println("Select the details of all the library books,which is from a specific location");
		    	System.out.println("Enter the specific location  : ");
				l.setLiblocation(sc.next());
				l.fetchSpecificData();
				break;
				
				
				
				 
		    }
		    }
		}

	

		

	}


