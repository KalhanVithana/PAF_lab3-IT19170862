package Paflab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.Statement;

public class Item {

	/**
	 try 
	 { 
		 Class.forName("com.mysql.cj.jdbc.Driver");
	Connection  con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", ""); 
	
	String sql = "INSERT INTO myDB values(name)"+"values('abc')";
	
	java.sql.Statement st = con.createStatement();
	
	int rows = st.executeUpdate(sql);
	if(rows > 0) {
		
		System.out.println("added");
	}
	
	
	 //For testing
	if(con != null ) {
		
		 System.out.print("Successfully connected"); 
		 con.close();
	}
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 */
	
	
	public Connection connect()
	{ 
	 Connection con = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	  con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", ""); 
	 //For testing
	 System.out.print("Successfully connected"); 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return con; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 
		if (request.getParameter("itemCode") != null) 
		{ 
		 Item itemObj = new Item(); 
		 itemObj.connect();//For testing the connect method
		}
		
		
		
}
	
	public String insertItem(String code, String name, String price, String desc)
	{ 
	 String output = ""; 
	try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database"; 
	 } 
	 // create a prepared statement
	 String query = " insert into dataTable (`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)"
	 + " values (?, ?, ?, ?, ?)"; 
	 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, code); 
	 preparedStmt.setString(3, name); 
	 preparedStmt.setDouble(4, Double.parseDouble(price)); 
	 preparedStmt.setString(5, desc); 
	 
	 
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	catch (Exception e) 
	 { 
	 output = "Error while inserting"; 
	 System.err.println(e.getMessage()); 
	 } 
	return output; 
	}


}
