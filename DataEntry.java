package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataEntry {
	
	private IntegerProperty rowNoProperty;
	
	private StringProperty txt1Property, txt2Property, txt3Property, txt4Property;
	private StringProperty txt5Property, txt6Property, txt7Property, txt8Property;
	private StringProperty txt9Property, txt10Property, txt11Property, txt12Property;
	private StringProperty txt13Property, txt14Property, txt15Property;
	
	public DataEntry() {
		
		this.rowNoProperty = new SimpleIntegerProperty();
		
		this.txt1Property = new SimpleStringProperty();
		this.txt2Property = new SimpleStringProperty();
		this.txt3Property = new SimpleStringProperty();
		this.txt4Property = new SimpleStringProperty();
		this.txt5Property = new SimpleStringProperty();
		this.txt6Property = new SimpleStringProperty();
		this.txt7Property = new SimpleStringProperty();
		this.txt8Property = new SimpleStringProperty();
		this.txt9Property = new SimpleStringProperty();
		this.txt10Property = new SimpleStringProperty();
		this.txt11Property = new SimpleStringProperty();
		this.txt12Property = new SimpleStringProperty();
		this.txt13Property = new SimpleStringProperty();
		this.txt14Property = new SimpleStringProperty();
		this.txt15Property = new SimpleStringProperty();
	}
	
	//This is for Row Number
	public int getRowNoProperty() { return rowNoProperty.get();}
	public void setRowNoProperty(int rowNo) { this.rowNoProperty.set(rowNo);;	}
	public IntegerProperty getRNo() {	return rowNoProperty;	}
	
	//This is for other rows 
	public String getTxt1() {	return txt1Property.get();	}
	public void setTxt1(String t1) { this.txt1Property.set(t1);	}
	public StringProperty getText1() {	return txt1Property;	}
	
	public String getTxt2() {	return txt2Property.get();	}
	public void setTxt2(String t2) { this.txt2Property.set(t2);	}
	public StringProperty getText2() {	return txt2Property;	}
	
	public String getTxt3() {	return txt3Property.get();	}
	public void setTxt3(String t3) { this.txt3Property.set(t3);	}
	public StringProperty getText3() {	return txt3Property;	}

	public String getTxt4() {	return txt4Property.get();	}
	public void setTxt4(String t4) { this.txt4Property.set(t4);	}
	public StringProperty getText4() {	return txt4Property;	}

	public String getTxt5() {	return txt5Property.get();	}
	public void setTxt5(String t5) { this.txt5Property.set(t5);	}
	public StringProperty getText5() {	return txt5Property;	}
	
	public String getTxt6() {	return txt6Property.get();	}
	public void setTxt6(String t6) { this.txt6Property.set(t6);	}
	public StringProperty getText6() {	return txt6Property;	}
	
	public String getTxt7() {	return txt7Property.get();	}
	public void setTxt7(String t7) { this.txt7Property.set(t7);	}
	public StringProperty getText7() {	return txt7Property;	}
	
	public String getTxt8() {	return txt8Property.get();	}
	public void setTxt8(String t8) { this.txt8Property.set(t8);	}
	public StringProperty getText8() {	return txt8Property;	}
	
	public String getTxt9() {	return txt9Property.get();	}
	public void setTxt9(String t9) { this.txt9Property.set(t9);	}
	public StringProperty getText9() {	return txt9Property;	}
	
	public String getTxt10() {	return txt10Property.get();	}
	public void setTxt10(String t10) { this.txt10Property.set(t10);	}
	public StringProperty getText10() {	return txt10Property;	}
	
	public String getTxt11() {	return txt11Property.get();	}
	public void setTxt11(String t11) { this.txt11Property.set(t11);	}
	public StringProperty getText11() {	return txt11Property;	}
	
	public String getTxt12() {	return txt12Property.get();	}
	public void setTxt12(String t12) { this.txt12Property.set(t12);	}
	public StringProperty getText12() {	return txt12Property;	}
	
	public String getTxt13() {	return txt13Property.get();	}
	public void setTxt13(String t13) { this.txt13Property.set(t13);	}
	public StringProperty getText13() {	return txt13Property;	}
	
	public String getTxt14() {	return txt14Property.get();	}
	public void setTxt14(String t14) { this.txt14Property.set(t14);	}
	public StringProperty getText14() {	return txt14Property;	}
	
	public String getTxt15() {	return txt15Property.get();	}
	public void setTxt15(String t15) { this.txt15Property.set(t15);	}
	public StringProperty getText15() {	return txt15Property;	}	
	

}
