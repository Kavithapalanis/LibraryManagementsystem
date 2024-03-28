package LibraryManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class LibraryJDBCconnection {
	
	public static Connection con;
	//constructor
	public LibraryJDBCconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","kavi");
			System.out.println("Driver loaded");
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}

}

}

	


