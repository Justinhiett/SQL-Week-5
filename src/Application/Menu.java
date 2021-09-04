package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {  
	
	final static String CREATE_QUERY = "INSERT INTO titles VALUES(1000, 'Halo')";  
	final static String SELECT_QUERY = "SELECT * from titles";
	
	
	
	
	
	public static void main(String[] args) { 
		
		String connectionString = "jdbc:mysql://localhost:3306/games"; 
		
		
		try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "root");  
			System.out.println("Connected successfully!");  
			Menu menu = new Menu(); 
			
			menu.start();  
			
			 
			String selection = "";
			
			 Scanner scanner = new Scanner(System.in);
			do { 
				printMenu(); 
				selection = scanner.nextLine(); 
				
				if (selection.equals("1")) {
					PreparedStatement ps = conn.prepareStatement(SELECT_QUERY); 
					ResultSet rs = ps.executeQuery(); 
				} else if (selection.equals("2")) {
					PreparedStatement ps = conn.prepareStatement(CREATE_QUERY); 
					ps.executeUpdate();
				} else if (selection.equals("3")) {
					//updateTitle();
				} else if (selection.equals("4")) {
					//deleteTitle();
				} 
				
				System.out.println("Press enter to continue...."); 
				scanner.nextLine();
				
				
			} while (!selection.equals("-1"));
		} catch (SQLException e) {
			System.out.println("Error connecting to the database. "); 
			e.printStackTrace();
		}
		
         
		 
		 
		 
		
			
			
		 
		} 
	
	
	
		
		private static void printMenu() { 
			List<String> options = Arrays.asList("Display Titles", "Create Title", "Update Title", "Delete Title");
			System.out.println("Select an Option:\n****************************"); 
			
			for (int i = 0; i < options.size(); i++) {
				System.out.println(i + 1 + ") " + options.get(i)); 
				
			} 
			
		} 
		
	
	
	
	
	private static void createTitle(Connection conn) throws SQLException { 
		
		
	}
	
	public void start() {
		String selection = "";  
	}
	
}
