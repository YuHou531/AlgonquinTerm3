package cst8390.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Assignment1 extends Application {

	/** 
	 * This class will store values for Property Tax Data objects (what you read from property_tax_report.csv)
	 * 
	 * @author Yu Hou
	 */
	public class propertyTaxData {
		
		private String myPID; //011-095-563
		private String myLEGAL_TYPE; //LAND
		private String myFOLIO; //122730560000
		private String myLAND_COORDINATE; //12273056
		private String myZONE_NAME; //RS-5
		private String myZONE_CATEGORY; //One Family Dwelling
		private String myLOT; //6
		private String myBLOCK; //829
		private String myPLAN; //VAP6011
		private String myDISTRICT_LOT; //526
		private String myFROM_CIVIC_NUMBER; //
		private String myTO_CIVIC_NUMBER; //5012
		private String mySTREET_NAME; //MARGUERITE ST
		private String myPROPERTY_POSTAL_CODE; //V6M 3K1
		private String myLegalLine1; //LOT 6  BLOCK 829  PLAN VAP6011  DIS
		private String myLegalLine2; //TRICT LOT 526  NEW WESTMINSTER
		private String myLegalLine3; //
		private String myLegalLine4; //
		private String myLegalLine5; //
		private long myCURRENT_LAND_VALUE; //4081000
		private long myCURRENT_IMPROVEMENT_VALUE; //814000
		private int myTAX_ASSESSMENT_YEAR; //2015
		private long myPREVIOUS_LAND_VALUE; //3617000
		private long myPREVIOUS_IMPROVEMENT_VALUE; //801000
		private int myYEAR_BUILT; //1956
		private int myBIG_IMPROVEMENT_YEAR; //2006
		private double myTAX_LEVY; //18484.54
		private int myNEIGHBOURHOOD_CODE; //8
		
		/**
		 * Constructor 
		 * 
		 * @param myPID PID
		 * @param myLEGAL_TYPE LEGAL_TYPE
		 * @param myFOLIO FOLIO
		 * @param myLAND_COORDINATE LAND_COORDINATE
		 * @param myZONE_NAME ZONE_NAME
		 * @param myZONE_CATEGORY ZONE_CATEGORY
		 * @param myLOT LOT
		 * @param myBLOCK BLOCK
		 * @param myPLAN PLAN
		 * @param myDISTRICT_LOT DISTRICT_LOT
		 * @param myFROM_CIVIC_NUMBER FROM_CIVIC_NUMBER
		 * @param myTO_CIVIC_NUMBER TO_CIVIC_NUMBER
		 * @param mySTREET_NAME STREET_NAME
		 * @param myPROPERTY_POSTAL_CODE PROPERTY_POSTAL_CODE
		 * @param myLegalLine1 legal description line 1
		 * @param myLegalLine2 legal description line 2
		 * @param myLegalLine3 legal description line 3
		 * @param myLegalLine4 legal description line 4
		 * @param myLegalLine5 legal description line 5
		 * @param myCURRENT_LAND_VALUE CURRENT_LAND_VALUE
		 * @param myCURRENT_IMPROVEMENT_VALUE CURRENT_IMPROVEMENT_VALUE
		 * @param myTAX_ASSESSMENT_YEAR TAX_ASSESSMENT_YEAR
		 * @param myPREVIOUS_LAND_VALUE PREVIOUS_LAND_VALUE
		 * @param myPREVIOUS_IMPROVEMENT_VALUE PREVIOUS_IMPROVEMENT_VALUE
		 * @param myYEAR_BUILT YEAR_BUILT
		 * @param myBIG_IMPROVEMENT_YEAR BIG_IMPROVEMENT_YEAR
		 * @param myTAX_LEVY TAX_LEVY
		 * @param myNEIGHBOURHOOD_CODE NEIGHBOURHOOD_CODE
		 */
		public propertyTaxData(String myPID, String myLEGAL_TYPE, String myFOLIO, String myLAND_COORDINATE, String myZONE_NAME,
				String myZONE_CATEGORY, String myLOT, String myBLOCK, String myPLAN, String myDISTRICT_LOT, String myFROM_CIVIC_NUMBER,
				String myTO_CIVIC_NUMBER, String mySTREET_NAME, String myPROPERTY_POSTAL_CODE, String myLegalLine1, String myLegalLine2,
				String myLegalLine3, String myLegalLine4, String myLegalLine5, long myCURRENT_LAND_VALUE, long myCURRENT_IMPROVEMENT_VALUE,
				int myTAX_ASSESSMENT_YEAR, long myPREVIOUS_LAND_VALUE, long myPREVIOUS_IMPROVEMENT_VALUE, int myYEAR_BUILT, int myBIG_IMPROVEMENT_YEAR,
				double myTAX_LEVY, int myNEIGHBOURHOOD_CODE)
		{
			this.myPID = myPID;
			this.myLEGAL_TYPE = myLEGAL_TYPE;
			this.myFOLIO = myFOLIO;
			this.myLAND_COORDINATE = myLAND_COORDINATE;
			this.myZONE_NAME = myZONE_NAME;
			this.myZONE_CATEGORY = myZONE_CATEGORY;
			this.myLOT = myLOT;
			this.myBLOCK = myBLOCK;
			this.myPLAN = myPLAN;
			this.myDISTRICT_LOT = myDISTRICT_LOT;
			this.myFROM_CIVIC_NUMBER = myFROM_CIVIC_NUMBER;
			this.myTO_CIVIC_NUMBER = myTO_CIVIC_NUMBER;
			this.mySTREET_NAME = mySTREET_NAME;
			this.myPROPERTY_POSTAL_CODE = myPROPERTY_POSTAL_CODE;
			this.myLegalLine1 = myLegalLine1;
			this.myLegalLine2 = myLegalLine2;
			this.myLegalLine3 = myLegalLine3;
			this.myLegalLine4 = myLegalLine4;
			this.myLegalLine5 = myLegalLine5;
			this.myCURRENT_LAND_VALUE = myCURRENT_LAND_VALUE;
			this.myCURRENT_IMPROVEMENT_VALUE = myCURRENT_IMPROVEMENT_VALUE;
			this.myTAX_ASSESSMENT_YEAR = myTAX_ASSESSMENT_YEAR;
			this.myPREVIOUS_LAND_VALUE = myPREVIOUS_LAND_VALUE;
			this.myPREVIOUS_IMPROVEMENT_VALUE = myPREVIOUS_IMPROVEMENT_VALUE;
			this.myYEAR_BUILT = myYEAR_BUILT;
			this.myBIG_IMPROVEMENT_YEAR = myBIG_IMPROVEMENT_YEAR;
			this.myTAX_LEVY = myTAX_LEVY;
			this.myNEIGHBOURHOOD_CODE = myNEIGHBOURHOOD_CODE;          
		}
		
		/**
		 * @return myPID
		 */
		public String getPID() {
			return myPID;
		}
		
		/**
		 * @return myLEGAL_TYPE
		 */
		public String getLEGAL_TYPE() {
			return myLEGAL_TYPE;
		}
		
		/**
		 * @return myFOLIO
		 */
		public String getFOLIO() {
			return myFOLIO;
		}
		
		/**
		 * @return myLAND_COORDINATE
		 */
		public String getLAND_COORDINATE() {
			return myLAND_COORDINATE;
		}
		
		/**
		 * @return myZONE_NAME
		 */
		public String getZONE_NAME() {
			return myZONE_NAME;
		}
		
		/**
		 * @return myZONE_CATEGORY
		 */
		public String getZONE_CATEGORYz() {
			return myZONE_CATEGORY;
		}
		
		/**
		 * @return myLOT
		 */
		public String getLOT() {
			return myLOT;
		}
		
		/**
		 * @return myBLOCK
		 */
		public String getBLOCK() {
			return myBLOCK;
		}
		
		/**
		 * @return myPLAN
		 */
		public String getPLAN() {
			return myPLAN;
		}
		
		/**
		 * @return myDISTRICT_LOT
		 */
		public String getDISTRICT_LOT() {
			return myDISTRICT_LOT;
		}
		
		/**
		 * @return myFROM_CIVIC_NUMBER
		 */
		public String getFROM_CIVIC_NUMBER() {
			return myFROM_CIVIC_NUMBER;
		}
		
		/**
		 * @return myTO_CIVIC_NUMBER
		 */
		public String getTO_CIVIC_NUMBER() {
			return myTO_CIVIC_NUMBER;
		}
		
		/**
		 * @return mySTREET_NAME
		 */
		public String getSTREET_NAME() {
			return mySTREET_NAME;
		}
		
		/**
		 * @return myPROPERTY_POSTAL_CODE
		 */
		public String getPROPERTY_POSTAL_CODE() {
			return myPROPERTY_POSTAL_CODE;
		}

		/**
		 * @return myLegalLine1
		 */
		public String getLegalLine1() {
			return myLegalLine1;
		}
		
		/**
		 * @return myLegalLine2
		 */
		public String getLegalLine2() {
			return myLegalLine2;
		}
		
		/**
		 * @return myLegalLine3
		 */
		public String getLegalLine3() {
			return myLegalLine3;
		}
		
		/**
		 * @return myLegalLine4
		 */
		public String getLegalLine4() {
			return myLegalLine4;
		}
		
		/**
		 * @return myLegalLine5
		 */
		public String getLegalLine5() {
			return myLegalLine5;
		}
		
		/**
		 * @return myCURRENT_LAND_VALUE
		 */
		public long getCURRENT_LAND_VALUE() {
			return myCURRENT_LAND_VALUE;
		}
		
		/**
		 * @return myCURRENT_IMPROVEMENT_VALUE
		 */
		public long getCURRENT_IMPROVEMENT_VALUE() {
			return myCURRENT_IMPROVEMENT_VALUE;
		}
		
		/**
		 * @return myTAX_ASSESSMENT_YEAR
		 */
		public int getTAX_ASSESSMENT_YEAR() {
			return myTAX_ASSESSMENT_YEAR;
		}
		
		/**
		 * @return myPREVIOUS_LAND_VALUE
		 */
		public long getPREVIOUS_LAND_VALUE() {
			return myPREVIOUS_LAND_VALUE;
		}
		
		/**
		 * @return myPREVIOUS_IMPROVEMENT_VALUE
		 */
		public long getPREVIOUS_IMPROVEMENT_VALUE() {
			return myPREVIOUS_IMPROVEMENT_VALUE;
		}
		
		/**
		 * @return myYEAR_BUILT
		 */
		public int getYEAR_BUILT() {
			return myYEAR_BUILT;
		}
		
		/**
		 * @return myBIG_IMPROVEMENT_YEAR
		 */
		public int getBIG_IMPROVEMENT_YEAR() {
			return myBIG_IMPROVEMENT_YEAR;
		}
		
		/**
		 * @return myTAX_LEVY
		 */
		public double getTAX_LEVY() {
			return myTAX_LEVY;
		}
		
		/**
		 * @return myNEIGHBOURHOOD_CODE
		 */
		public int getNEIGHBOURHOOD_CODE() {
			return myNEIGHBOURHOOD_CODE;
		}
	}
	
	/** A class that will store values for Data objects (what you read in from lines of the file).
	 * 
	 * @author etorunski
	 *
	 */
	public class MyData{
		public MyData(String n, int a, int sal)
		{
			myName = n;
			myAge = a;
			annualSalary = sal;
		}
		
		public String getName() 	{ return myName; }
		public Integer getAge() 	{ return myAge; }
		public Integer getSalary() 	{ return annualSalary; }
		
		private String myName;
		private int myAge;
		private int annualSalary;
	}
	
	/**
	 * main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//read the CSV data
		String workingdirectory = System.getProperty("user.dir");
		String fileName = workingdirectory + "\\property_tax_report.csv";
		readCSVFile(fileName);
		
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button newButton = new Button("Go!");
		
		//Create the table, and 3 columns: 
		TableView<MyData> table = new TableView<>();
		TableColumn<MyData, String> nameCol = new TableColumn<>("Name");	
	    TableColumn<MyData, String> ageCol = new TableColumn<>("Age");
	    TableColumn<MyData, String> salCol = new TableColumn<>("Salary");
	    table.getColumns().addAll(nameCol, ageCol, salCol);
	    
	    //Tell the columns what getter function to call for their data:
	    nameCol.setCellValueFactory(
	    	    new PropertyValueFactory<MyData,String>("Name") //Will call "getName()" from objects in the list
	    	);
	    
	    ageCol.setCellValueFactory(
	    	    new PropertyValueFactory<MyData,String>("Age")  //Will call "getAge()" from objects in the list
	    	);
	    
	    salCol.setCellValueFactory(
	    	    new PropertyValueFactory<MyData,String>("Salary") //Will call "getSalary()" from objects in the list
	    	);

	    
	   
	    
	    //Create a list of data:
	    final ObservableList<MyData> data = FXCollections.observableArrayList();
	    //add elements one at a time:
	    data.add(new MyData("Eric", 20, 12345));
	    data.add(new MyData("Cire", 40, 54321));
	    data.add(new MyData("Rice", 60, 123321));
		 
	    
	    
	    
	    //Finally give the data to the table for rendering:
	     table.setItems(data);
	     
	     
		primaryStage.setScene(new Scene(new VBox(newButton, table), 640, 480));
		
		//when clicking the button, call openOtherStage();
		newButton.setOnMouseClicked(clickEvent -> openOtherStage() );
		
		primaryStage.show();
	}

	
	protected void openOtherStage()
	{
		
		VBox root = new VBox();
		
		//Create a second stage object
		Stage newStage = new Stage();
		
		//Create a scene object to show objects
		Scene newScene = new Scene(root, 500, 500);
		
		//Create a ListView object
		ListView<Number> list = new ListView<>();
		
		//Create a list of data numbers
		ObservableList<Number> items = FXCollections.observableArrayList ( 1, 2, 3, 4, 5.5 );
		
		//Give the listView a list of numbers:
		list.setItems(items);
		
		root.getChildren().add(list);
		
		//Tell the stage which scene to display
		newStage.setScene(newScene);
		
		//make the stage visible
		newStage.show();
	}
	
	
	/**  
	 * This is the basic parts of reading a CSV file.
	 * 
	 * @param filename The string representing a filename to open.
	 */
	public static void readCSVFile(String filename)
	{
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename)))
		{
			String line = "";
			while(line != null){
				
				//get a line of text from the file
				line = reader.readLine();
				
				if( line != null) {
					//Split the line by commas
					String [] partsOfLine = line.split(",");

					//The array partsOfLine should now hold everything in the line between commas
					String first = partsOfLine[0];
					String second = partsOfLine[1];
					String third = partsOfLine[2];
				}

			}
			
		}catch(IOException ioe)
		{
			System.out.println("Problem reading csv: " + ioe.getMessage());
		}
	}

}
