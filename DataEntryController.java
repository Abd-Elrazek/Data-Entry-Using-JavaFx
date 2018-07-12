package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class DataEntryController {
	
	int rn;

    @FXML
    private JFXTextField t1, t2, t3, t4 , t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;

    @FXML
    private JFXButton start;

    @FXML
    private JFXButton save;
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private StackPane stackPane2;

    @FXML
    private JFXButton update;
    
    @FXML
    private Label dayCount;
    
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
    private void startData(ActionEvent Event) {
    	
    	String line, line2;
		int dayC=0, dayNo=0, day;
		
		//Enable all text fields and buttons
		t1.setDisable(false); t2.setDisable(false); t3.setDisable(false); t4.setDisable(false);
		t5.setDisable(false); t6.setDisable(false); t7.setDisable(false); t8.setDisable(false);
		t9.setDisable(false); t10.setDisable(false); t11.setDisable(false); t12.setDisable(false);
		t13.setDisable(false); t14.setDisable(false); t15.setDisable(false);
		
		searchRowNo.setDisable(false);
		
		save.setDisable(false); update.setDisable(false);
		
		//For reading the txt file
		
    	BufferedReader br = null;
    	BufferedReader br2 = null;
    	
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Acer\\Desktop\\day.txt"));
			line = br.readLine();	dayNo=Integer.parseInt(line);	
			
			br2 = new BufferedReader(new FileReader("C:\\Users\\Acer\\Desktop\\count.txt"));
			line2 = br2.readLine();	dayC=Integer.parseInt(line2);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//disabling the buttons after 6th day
		if (dayC>=6) {
			
        	JFXDialogLayout content = new JFXDialogLayout();
        	content.setBody(new Text("Its Day "+dayC+" You Cannot WorK Anymore\n "
        			+ "Submit Your Work to the Authorised Party\n"));
        	JFXDialog dialog = new JFXDialog(stackPane2, content, JFXDialog.DialogTransition.CENTER);
        	JFXButton button = new JFXButton("OK");
        	button.setOnAction(new EventHandler<ActionEvent>(){
        		@Override
        		public void handle(ActionEvent event) {
        			dialog.close();
        		}
        	});
        	content.setActions(button);
        	dialog.show();
			
			t1.setDisable(true); t2.setDisable(true); t3.setDisable(true); t4.setDisable(true);
			t5.setDisable(true); t6.setDisable(true); t7.setDisable(true); t8.setDisable(true);
			t9.setDisable(true); t10.setDisable(true); t11.setDisable(true); t12.setDisable(true);
			t13.setDisable(true); t14.setDisable(true); t15.setDisable(true);
			
			searchRowNo.setDisable(true);
			
			save.setDisable(true); update.setDisable(true);
		}
		
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	       day = calendar.get(Calendar.DATE);
	       
	       if(day!=dayNo) {
	    	   dayNo = day;
	    	   dayC+=1;
	    	   System.out.println("Day no "+dayNo+" Day count "+dayC);
	    	   try {
	    	   File file = new File("C:\\Users\\Acer\\Desktop\\day.txt");
	    	   File file2 = new File("C:\\Users\\Acer\\Desktop\\count.txt");
	    	   PrintWriter pw = new PrintWriter(file);
	    	   PrintWriter pw2 = new PrintWriter(file2);
	    	   pw.println(dayNo);
	    	   pw2.println(dayC);
	    	   pw.close(); pw2.close();
	    	   }
	    	   catch(IOException e) {
	    		   e.printStackTrace();
	    	   }
	       }
	       
	       dayCount.setText("Day "+dayC);
    }
    
    
    
    @FXML
    private void insertData(ActionEvent event) throws ClassNotFoundException, SQLException{
    	try {
    	DataEntryModel.insertData(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(), t6.getText(), t7.getText(), t8.getText(), t9.getText(), t10.getText(), t11.getText(), t12.getText(), t13.getText(), t14.getText(), t15.getText());
    	
    	
    	ObservableList<DataEntry> deList = DataEntryModel.getAllRecords();
    	populateTable(deList);
    	
    	t1.clear(); t2.clear(); t3.clear(); t4.clear();
    	t5.clear(); t6.clear(); t7.clear(); t8.clear();
    	t9.clear(); t10.clear(); t11.clear(); t12.clear();
    	t15.clear(); t14.clear(); t13.clear();
    	
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
    	
    		
    		
    		ObservableList<DataEntry> deList = DataEntryModel.getAllRecords();
        	populateTable(deList);
        	
        	//for dialog box
        	
        	
        	JFXDialogLayout content = new JFXDialogLayout();
        	content.setBody(new Text("The Row "+rn+" Updated Sucessfully!\n"));
        	JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        	JFXButton button = new JFXButton("OK");
        	button.setOnAction(new EventHandler<ActionEvent>(){
        		@Override
        		public void handle(ActionEvent event) {
        			dialog.close();
        		}
        	});
        	content.setActions(button);
        	dialog.show();
        	
        	
        	//for clearing the text fields
        	t1.clear(); t2.clear(); t3.clear(); t4.clear();
        	t5.clear(); t6.clear(); t7.clear(); t8.clear();
        	t9.clear(); t10.clear(); t11.clear(); t12.clear();
        	t15.clear(); t14.clear(); t13.clear();
        	
    	}
    		catch(SQLException e) {
    			System.out.println("Exception  Occure In Update "+e);
    			throw e;
    		}
    	
    }
    
    
    
    @FXML
    private void initialize()throws Exception{
    	
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
