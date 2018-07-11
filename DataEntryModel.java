package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DataEntryModel {
	
	public static void insertData(String t1, String t2, String t3, String t4, 
			String t5, String t6, String t7, String t8, 
			String t9, String t10, String t11, String t12, 
			String t13, String t14, String t15) throws SQLException, ClassNotFoundException {
		
		String sql = "insert into Test([1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15]) "
				+ "values('"+t1+"', '"+t2+"', '"+t3+"', '"+t4+"', '"+t5+"', '"+t6+"', '"+t7+"', '"+t8+"', '"+t9+"', '"+t10+"', '"+t11+"', '"+t12+"', '"+t13+"', '"+t14+"', '"+t15+"')";
		try {
		DataEntryUtil.dbExecuteQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("Exception while Inserting the Data "+e);
			throw e;
		}
	}
	
	public static void updateData (int rowNo,String t1, String t2, String t3, String t4, 
			String t5, String t6, String t7, String t8, 
			String t9, String t10, String t11, String t12, 
			String t13, String t14, String t15) throws SQLException, ClassNotFoundException{
		String sql = "update Test set [1] = '"+t1+"', [2]= '"+t2+"', [3]= '"+t3+"', [4]='"+t4+"', "
				+ "[5] = '"+t5+"', [6]= '"+t6+"', [7] = '"+t7+"', [8] = '"+t8+"', "
						+ "[9] = '"+t9+"', [10] = '"+t10+"', [11] = '"+t11+"', [12] = '"+t12+"', [13] = '"+t1+"', [14] = '"+t14+"', [15] = '"+t15+"'"
								+ "where [Row Number] = '"+rowNo+"'";
		try {
			DataEntryUtil.dbExecuteQuery(sql);
			}
			catch(SQLException e) {
				System.out.println("Exception while Updating the Data "+e);
				e.printStackTrace();
				throw e;
			}
		
	}
	
	public static ObservableList<DataEntry> getAllRecords() throws ClassNotFoundException, SQLException{
		String sql = "select * from Test";
		
		try {
			ResultSet rsSet = DataEntryUtil.dbExecute(sql);
			ObservableList<DataEntry> deList = getDEObject(rsSet);
			return deList;
			
		}
		catch(SQLException e) {
			System.out.println("Exception while fetching the data "+e);
			e.printStackTrace();
			throw e;
		}
	}

	private static ObservableList<DataEntry> getDEObject(ResultSet rsSet)throws ClassNotFoundException, SQLException {
		try {
			ObservableList<DataEntry> deList = FXCollections.observableArrayList();
			
			while(rsSet.next()) {
				
				DataEntry de = new DataEntry();
				
				de.setRowNoProperty(rsSet.getInt("Row_Number"));
				
				de.setTxt1(rsSet.getString("1"));
				de.setTxt2(rsSet.getString("2"));
				de.setTxt3(rsSet.getString("3"));
				de.setTxt4(rsSet.getString("4"));
				de.setTxt5(rsSet.getString("5"));
				de.setTxt6(rsSet.getString("6"));
				de.setTxt7(rsSet.getString("7"));
				de.setTxt8(rsSet.getString("8"));
				de.setTxt9(rsSet.getString("9"));
				de.setTxt10(rsSet.getString("10"));
				de.setTxt11(rsSet.getString("11"));
				de.setTxt12(rsSet.getString("12"));
				de.setTxt13(rsSet.getString("13"));
				de.setTxt14(rsSet.getString("14"));
				de.setTxt15(rsSet.getString("15"));
				
				deList.add(de);
			}
			return deList;
		}
		catch(SQLException e) {
			System.out.println("Exception while fetching the data from DB "+e);
			e.printStackTrace();
			throw e;
		}

	}

}