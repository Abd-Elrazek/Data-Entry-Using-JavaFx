package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.rowset.CachedRowSetImpl;

public class DataEntryUtil {
	
	private static final String JDBC_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
	
	private static Connection connection = null;
	
	static final String msAccDB = "C:/Database/Project V1.accdb;jackcessOpener=application.CryptCodecOpener";
    static final String connSt = "jdbc:ucanaccess://" + msAccDB;
    
    public static void dbConnect() throws ClassNotFoundException, SQLException{
    	//Register the database driver
    	try {
    		Class.forName(JDBC_DRIVER);
    		
    	}
    	catch (ClassNotFoundException e) {
    		System.out.println("Where is your MS Access JDBC Driver?");
    		e.printStackTrace();
    		throw e;
    	}
    	
    	System.out.println("JDBC Driver has been Registered");
    	//Connecting the database 
    	try {
    		connection = DriverManager.getConnection(connSt, "", "rj47@123");//location, username and password
    	}
    	catch(SQLException e) {
    		System.out.println("Connection Failed! Check Output Console "+e);
    		throw e;
    	}
    }
	
	public static void dbDisconnect() throws SQLException{
		try {
			
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			
		}
		catch(SQLException e) {
			throw e;
		}
	}
	//this method is used for insert, delete and update operations
	public static void dbExecuteQuery(String sqlStmt) throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		try {
			dbConnect();
			stmt = connection.createStatement();
			stmt.executeUpdate(sqlStmt);
		}
		catch(SQLException e) {
			System.out.println("Problem occured in dbExecuteQuery Operation "+e);
			throw e;
		}
		finally {
			if(stmt!=null) {
				stmt.close();
			}
			dbDisconnect();
		}
	}
	
	//retrieve records from database
	public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		CachedRowSetImpl crs = null;
		
		try {
			dbConnect();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			crs = new CachedRowSetImpl();
			crs.populate(rs);
		}
		catch(SQLException e) {
			System.out.println("Problem occured in dbExecute Operation "+e);
			throw e;
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			dbDisconnect();
		}
		return crs;
	}

}
