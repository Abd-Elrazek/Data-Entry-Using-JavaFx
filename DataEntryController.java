package application;

import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DataEntryController {
	
	int rn;

    @FXML
    private JFXTextField t1, t2, t3, t4 , t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;

    @FXML
    private JFXButton start;

    @FXML
    private JFXButton lock;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton update;
    
    @FXML
    private Label resultConsole;
    
    @FXML
    private JFXTextField searchRowNo;
    
    @FXML
    private TableView<DataEntry> tabView;
    
    @FXML
    private TableColumn<DataEntry, Integer> rowNumber;
    
    @FXML
    private TableColumn<DataEntry, String> c1; 
    @FXML
    private TableColumn<DataEntry, String> c2; 
    @FXML
    private TableColumn<DataEntry, String> c3; 
    @FXML
    private TableColumn<DataEntry, String> c4; 
    @FXML
    private TableColumn<DataEntry, String> c5; 
    @FXML
    private TableColumn<DataEntry, String> c6; 
    @FXML
    private TableColumn<DataEntry, String> c7; 
    @FXML
    private TableColumn<DataEntry, String> c8; 
    @FXML
    private TableColumn<DataEntry, String> c9; 
    @FXML
    private TableColumn<DataEntry, String> c10; 
    @FXML
    private TableColumn<DataEntry, String> c11; 
    @FXML
    private TableColumn<DataEntry, String> c12; 
    @FXML
    private TableColumn<DataEntry, String> c13; 
    @FXML
    private TableColumn<DataEntry, String> c14; 
    @FXML
    private TableColumn<DataEntry, String> c15;
    
    @FXML
    private void insertData(ActionEvent event) throws ClassNotFoundException, SQLException{
    	try {
    	DataEntryModel.insertData(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText(), t8.getText(), t9.getText(), t10.getText(), t11.getText(), t12.getText(), t13.getText(), t14.getText(), t15.getText());
    	resultConsole.setText("Data Added Successfully!");
    	
    	ObservableList<DataEntry> deList = DataEntryModel.getAllRecords();
    	populateTable(deList);
    	
    	}
    	catch(SQLException e) {
    		System.out.println("Exception Occer In Insertion "+e);
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    @FXML
    private void updateData(ActionEvent event) throws ClassNotFoundException, SQLException{
    	rn = Integer.parseInt(searchRowNo.getText());
    	try {
    		DataEntryModel.updateData(rn, t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText(), t8.getText(), t9.getText(), t10.getText(), t11.getText(), t12.getText(), t13.getText(), t14.getText(), t15.getText());
    	
    		resultConsole.setText("Data Updated Successfully!");
    		
    		ObservableList<DataEntry> deList = DataEntryModel.getAllRecords();
        	populateTable(deList);
    	}
    		catch(SQLException e) {
    			System.out.println("Exception  Occure In Update "+e);
    			throw e;
    		}
    	
    }
    
    @FXML
    private void intialize()throws Exception{
    	
    	rowNumber.setCellValueFactory(cellData -> cellData.getValue().getRNo().asObject());
    	
    	c1.setCellValueFactory(cellData -> cellData.getValue().getText1());
    	c2.setCellValueFactory(cellData -> cellData.getValue().getText2());
    	c3.setCellValueFactory(cellData -> cellData.getValue().getText3());
    	c4.setCellValueFactory(cellData -> cellData.getValue().getText4());
    	c5.setCellValueFactory(cellData -> cellData.getValue().getText5());
    	c6.setCellValueFactory(cellData -> cellData.getValue().getText6());
    	c7.setCellValueFactory(cellData -> cellData.getValue().getText7());
    	c8.setCellValueFactory(cellData -> cellData.getValue().getText8());
    	c9.setCellValueFactory(cellData -> cellData.getValue().getText9());
    	c10.setCellValueFactory(cellData -> cellData.getValue().getText10());
    	c11.setCellValueFactory(cellData -> cellData.getValue().getText11());
    	c12.setCellValueFactory(cellData -> cellData.getValue().getText12());
    	c13.setCellValueFactory(cellData -> cellData.getValue().getText13());
    	c14.setCellValueFactory(cellData -> cellData.getValue().getText14());
    	c15.setCellValueFactory(cellData -> cellData.getValue().getText15());
    	
    	ObservableList<DataEntry> deList = DataEntryModel.getAllRecords();
    	populateTable(deList);
    }

	private void populateTable(ObservableList<DataEntry> deList) {
		tabView.setItems(deList);
		
	}


}
