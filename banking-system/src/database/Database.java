package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static String dbname = "bank";
	private static String url = "jdbc:mysql://localhost/"+dbname+"?useSSL=false";
	private static String user = "root";
	private static String password = "";
	private static Connection con;
	
	public static Connection connect(){
		if(con!=null) {
			return con;
		}
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,user,password);
				return con;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static void disconnect() {
		if(con==null) {
			return;
		}
		try {
			con.close();
			con=null;
		}catch(Exception e) {	
			e.printStackTrace();
		}
	}
	
	
}
