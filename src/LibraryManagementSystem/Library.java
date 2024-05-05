package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import LibraryManagementSystem.LibraryJDBCconnection;
import LibraryManagementSystem.Library;

public class Library {
	
	public static int bookid;
    public static String bookname;
	public static String author;
	public static int yearpublish;
	public static int cost;
	public static String liblocation;
	
	public static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	
	static {
		
		LibraryJDBCconnection j = new LibraryJDBCconnection();
		con=LibraryJDBCconnection.con;
		System.out.println("connection established");
		
		
	}

	public static int getBookid() {
		return bookid;
	}

	public static void setBookid(int bookid) {
		Library.bookid = bookid;
	}

	public static String getBookname() {
		return bookname;
	}

	public static void setBookname(String bookname) {
		Library.bookname = bookname;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setAuthor(String author) {
		Library.author = author;
	}

	public static int getYearpublish() {
		return yearpublish;
	}

	public static void setYearpublish(int yearpublish) {
		Library.yearpublish = yearpublish;
	}

	public static int getCost() {
		return cost;
	}

	public static void setCost(int cost) {
		Library.cost = cost;
	}

	public static String getLiblocation() {
		return liblocation;
	}

	public static void setLiblocation(String l) {
		Library.liblocation = l;
	}
	
	public boolean insertData() {
		try {
			String query ="insert into libraryutable values(?,?,?,?,?,?)";//? mark are the place holders to take input from users
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,bookid);
			pstmt.setString(2, bookname);
			pstmt.setString(3, author);
			pstmt.setInt(4, yearpublish);
			pstmt.setInt(5, cost);
			pstmt.setString(6, liblocation);
			int x = pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	
	}
	public void fetchAllData() {
		try {
			String query = " Select * from  libraryutable";
			stmt=con.createStatement();
			res = stmt.executeQuery(query);
			
			while(res.next()==true) {
				System.out.println("ID: "+res.getInt(1));
				System.out.println("Book Name: "+res.getString(2));
				System.out.println("author: "+res.getString(3));
				System.out.println("yearpublished: "+res.getInt(4));
				System.out.println("cost : "+res.getInt(5));
				System.out.println("lib location : "+res.getString(6));
				System.out.println("-------------------------------------");
		
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public void fetchSpecificData() {
		try {
			String query = " Select * from libraryutable where liblocation=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,liblocation);
			res = pstmt.executeQuery();
			
			while(res.next()==true) {
				System.out.println("ID: "+res.getInt(1));
				System.out.println("Name: "+res.getString(2));
				System.out.println("Company: "+res.getString(3));
				System.out.println("salary: "+res.getInt(4));
				System.out.println("-------------------------------------");
		
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public void fetchBooksPublishedAfterYear(int year) {
	    try {
	        String query = "SELECT * FROM libraryutable WHERE yearpublish > ?";
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, year);
	        res = pstmt.executeQuery();

	        while (res.next()) {
	            System.out.println("ID: " + res.getInt(1));
	            System.out.println("Book Name: " + res.getString(2));
	            System.out.println("Author: " + res.getString(3));
	            System.out.println("Year Published: " + res.getInt(4));
	            System.out.println("Cost: " + res.getInt(5));
	            System.out.println("Library Location: " + res.getString(6));
	            System.out.println("-------------------------------------");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean updateLocation(int bookId, String newLocation) {
	    try {
	        String query = "UPDATE libraryutable SET liblocation = ? WHERE bookid = ?";
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, newLocation);
	        pstmt.setInt(2, bookId);
	       
	        int x = pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	        
	 //   
	}
	
	

	
	public boolean deleteBookById(int bookId) {
	    try {
	        String query = "DELETE FROM libraryutable WHERE bookid = ?";
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, bookId);
	        int rowsAffected = pstmt.executeUpdate();
	        
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}


