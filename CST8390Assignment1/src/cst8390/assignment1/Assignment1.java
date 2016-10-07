package cst8390.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
	public class PropertyTaxData {
		
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
		private String myNEIGHBOURHOOD_CODE; //8
		
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
		public PropertyTaxData(String myPID, String myLEGAL_TYPE, String myFOLIO, String myLAND_COORDINATE, String myZONE_NAME,
				String myZONE_CATEGORY, String myLOT, String myBLOCK, String myPLAN, String myDISTRICT_LOT, String myFROM_CIVIC_NUMBER,
				String myTO_CIVIC_NUMBER, String mySTREET_NAME, String myPROPERTY_POSTAL_CODE, String myLegalLine1, String myLegalLine2,
				String myLegalLine3, String myLegalLine4, String myLegalLine5, long myCURRENT_LAND_VALUE, long myCURRENT_IMPROVEMENT_VALUE,
				int myTAX_ASSESSMENT_YEAR, long myPREVIOUS_LAND_VALUE, long myPREVIOUS_IMPROVEMENT_VALUE, int myYEAR_BUILT, int myBIG_IMPROVEMENT_YEAR,
				double myTAX_LEVY, String myNEIGHBOURHOOD_CODE)
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
		public String getZONE_CATEGORY() {
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
		public String getNEIGHBOURHOOD_CODE() {
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
	 * main class for the application 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Step 0 - read the CSV data and load the values to data
		String workingdirectory = System.getProperty("user.dir");
		String fileName = workingdirectory + "\\property_tax_report.csv";
		List<PropertyTaxData> propertyData = readPropertyTaxCSVFile(fileName);
		
		int dataSize = propertyData.size();
		System.out.println("Total dataSize: " + dataSize);
		
		long currentLandValueSum = 0;
		long previousLandValueSum = 0;
		long houseAgeSum = 0;
		long numOfCommercial = 0;
		long numOfOneFamily = 0;
		long numOfMultipleFamily = 0;
		long highestPropertyValue = 0;
		
		for(int i = 0; i < dataSize; i++) {
			PropertyTaxData record = propertyData.get(i); 
			currentLandValueSum += record.getCURRENT_LAND_VALUE();
			if( highestPropertyValue < record.getCURRENT_LAND_VALUE())
				highestPropertyValue = record.getCURRENT_LAND_VALUE();
			//System.out.println(record.getCURRENT_LAND_VALUE());
			previousLandValueSum += record.getPREVIOUS_LAND_VALUE();
			//System.out.println(record.getPREVIOUS_LAND_VALUE());
			houseAgeSum += (2016 - record.getYEAR_BUILT());
			//System.out.println(2016 - record.getYEAR_BUILT());
			String zoneType = record.getZONE_CATEGORY();
			//System.out.println(zoneType);
			if( zoneType.contains("One Family"))
				numOfOneFamily++;
			if( zoneType.contains("Commercial"))
				numOfCommercial++;
			if( zoneType.contains("Multiple Family"))
				numOfMultipleFamily++;
			//System.out.println("------");
		}
		
		//Calculate Average Property Value
		System.out.println("currentLandValueSum " + currentLandValueSum);
		long averagePropertyValue = (long) currentLandValueSum / dataSize;
		System.out.println("averagePropertyValue " + averagePropertyValue);
		
		//Calculate Average House Age
		System.out.println("houseAgeSum " + houseAgeSum);
		int averageHouseAge = (int) houseAgeSum / dataSize;
		System.out.println("averageHouseAge " + averageHouseAge);
		
		//Calculate Total house value change
		System.out.println("previousLandValueSum " + previousLandValueSum);
		long totalHouseValueChange = currentLandValueSum - previousLandValueSum;
		System.out.println("totalHouseValueChange " + totalHouseValueChange);
		
		//Calculate Property Value / House Age Standard Deviation
		long diffPropertySum = 0;
		long diffAgeSum = 0;
		for(int i = 0; i < dataSize; i++) {
			diffPropertySum += Math.pow( propertyData.get(i).getCURRENT_LAND_VALUE() - averagePropertyValue, 2);
			diffAgeSum += Math.pow(2016 - propertyData.get(i).getYEAR_BUILT() - averageHouseAge, 2);
		}
		System.out.println("diffPropertySum " + diffPropertySum);
		System.out.println("diffAgeSum " + diffAgeSum);
		float sdPropertyValue = (float)Math.sqrt(diffPropertySum / dataSize);
		float sdHouseAge = (float)Math.sqrt(diffAgeSum / dataSize);
		System.out.println("sdPropertyValue " + sdPropertyValue);
		System.out.println("sdHouseAge " + sdHouseAge);
		
		// Number of Commercial / One Family / Multiple Family
		System.out.println("Number of Commercial for the entire data set " + numOfCommercial);
		System.out.println("Number of One Family for the entire data set " + numOfOneFamily);
		System.out.println("Number of Multiple Family for the entire data set " + numOfMultipleFamily);
		
		// Highest Property
		System.out.println("Highest Property is " + highestPropertyValue);
		// Separate few groups
		// 0 ~ 2000 (thousands)      - group 1
		// 2000 ~ 6000 (thousands)   - group 2
		// 6000 ~ 10000 (thousands)  - group 3 
		// 10000 ~ 14000 (thousands) - group 4
		// 14000 ~ 18000 (thousands) - group 5
		// 18000 plus (thousands)    - group 6
		List<PropertyTaxData> propertyDataGroup1 = new ArrayList<>();
		long minValueGroup1 = 0;
		long maxValueGroup1 = 0;
		boolean firstTimeGroup1 = true;
		List<PropertyTaxData> propertyDataGroup2 = new ArrayList<>();
		long minValueGroup2 = 0;
		long maxValueGroup2 = 0;
		boolean firstTimeGroup2 = true;
		List<PropertyTaxData> propertyDataGroup3 = new ArrayList<>();
		long minValueGroup3 = 0;
		long maxValueGroup3 = 0;
		boolean firstTimeGroup3 = true;
		List<PropertyTaxData> propertyDataGroup4 = new ArrayList<>();
		long minValueGroup4 = 0;
		long maxValueGroup4 = 0;
		boolean firstTimeGroup4 = true;
		List<PropertyTaxData> propertyDataGroup5 = new ArrayList<>();
		long minValueGroup5 = 0;
		long maxValueGroup5 = 0;
		boolean firstTimeGroup5 = true;
		List<PropertyTaxData> propertyDataGroup6 = new ArrayList<>();
		long minValueGroup6 = 0;
		long maxValueGroup6 = 0;
		boolean firstTimeGroup6 = true;
		List<String> streetNames = new ArrayList<>();
		String currentStreet = "";
		
		for(int i = 0; i < dataSize; i++) {
			PropertyTaxData record = propertyData.get(i);
			//Collect unique street names
			if(!currentStreet.equals(record.getSTREET_NAME()))
				streetNames.add(record.getSTREET_NAME());
			//Separate groups
			long value = record.getCURRENT_LAND_VALUE();
			if( value < 20000000) {
				propertyDataGroup1.add(record);
				if(firstTimeGroup1) {
					minValueGroup1 = value;
					maxValueGroup1 = value;
					firstTimeGroup1 = false;
				}
				if( minValueGroup1 >= value ) 
					minValueGroup1 = value;
				if( maxValueGroup1 <= value ) 
					maxValueGroup1 = value;
			}
			else if( value >= 20000000 && value < 60000000 ) {
				propertyDataGroup2.add(record);
				if(firstTimeGroup2) {
					minValueGroup2 = value;
					maxValueGroup2 = value;
					firstTimeGroup2 = false;
				}
				if( minValueGroup2 >= value ) 
					minValueGroup2 = value;
				if( maxValueGroup2 <= value ) 
					maxValueGroup2 = value;
			}
			else if( value >= 60000000 && value < 100000000 ) {
				propertyDataGroup3.add(record);
				if(firstTimeGroup3) {
					minValueGroup3 = value;
					maxValueGroup3 = value;
					firstTimeGroup3 = false;
				}
				if( minValueGroup3 >= value ) 
					minValueGroup3 = value;
				if( maxValueGroup3 <= value ) 
					maxValueGroup3 = value;
			}
			else if( value >= 100000000 && value < 140000000 ) {
				propertyDataGroup4.add(record);
				if(firstTimeGroup4) {
					minValueGroup4 = value;
					maxValueGroup4 = value;
					firstTimeGroup4 = false;
				}
				if( minValueGroup4 >= value ) 
					minValueGroup4 = value;
				if( maxValueGroup4 <= value ) 
					maxValueGroup4 = value;
			}
			else if( value >= 140000000 && value < 180000000 ) {
				propertyDataGroup5.add(record);
				if(firstTimeGroup5) {
					minValueGroup5 = value;
					maxValueGroup5 = value;
					firstTimeGroup5 = false;
				}
				if( minValueGroup5 >= value ) 
					minValueGroup5 = value;
				if( maxValueGroup5 <= value ) 
					maxValueGroup5 = value;
			}
			else if( value >= 180000000 ) {
				propertyDataGroup6.add(record);
				if(firstTimeGroup6) {
					minValueGroup6 = value;
					maxValueGroup6 = value;
					firstTimeGroup6 = false;
				}
				if( minValueGroup6 >= value ) 
					minValueGroup6 = value;
				if( maxValueGroup6 <= value ) 
					maxValueGroup6 = value;
			}
		}
		
		//Test streetNames
		System.out.println("StreetNames list size is " + streetNames.size());
		//Display group min value, max value and number of houses
		System.out.println("Group 1  0 ~ 2000 (thousands) minimum value " + minValueGroup1 + " maximum value " + maxValueGroup1 + " group total numbers " + propertyDataGroup1.size());
		System.out.println("Group 2  2000 ~ 6000 (thousands) minimum value " + minValueGroup2 + " maximum value " + maxValueGroup2 + " group total numbers " + propertyDataGroup2.size());
		System.out.println("Group 3  6000 ~ 10000 (thousands) minimum value " + minValueGroup3 + " maximum value " + maxValueGroup3 + " group total numbers " + propertyDataGroup3.size());
		System.out.println("Group 4  10000 ~ 14000 (thousands) minimum value " + minValueGroup4 + " maximum value " + maxValueGroup4 + " group total numbers " + propertyDataGroup4.size());
		System.out.println("Group 5  10000 ~ 18000 (thousands) minimum value " + minValueGroup5 + " maximum value " + maxValueGroup5 + " group total numbers " + propertyDataGroup5.size());
		System.out.println("Group 6  18000 plus (thousands) minimum value " + minValueGroup6 + " maximum value " + maxValueGroup6 + " group total numbers " + propertyDataGroup6.size());
		
		//Step 1 - Average property value and standard deviation for the entire data set. 
		//Step 2 - Average house age and standard deviation for the entire data set.
		//Step 3 - Total house value change for the entire data set (current land value – previous land value).
		//Step 4 - Number of Commercial, One Family and Multiple Family Dwelling for the entire data set.
		//Step 5 - The maximumvalue, minimumvalue, and number of homes with house value by increments of $25000. 
		//         For example, this could be a table, bar chart, or pie chart, which shows the number of homes 
		//         with value from (thousands) 100 – 125, 125-150, 150-175, 175-200, etc all the way to the 
		//         maximum first “bin” or interval that has 0 (this should be somewhere in the millions..)
		//Step 6 - The user should be able to double-click on any of the displays for items 1-5 to drill down to 
		//         show more detail on the calculation. The next level of detail should be a stage with a  ListView 
		//         by street name, and then double-clicking on a given item should open another stage showing the 
		//         calculation by postal code. For example, double-clicking on the property value should show a 
		//         display of property values by street. Double-clicking on a given street name should then show 
		//         the property values by postal code on that street.
		
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
		newButton.setOnMouseClicked(clickEvent -> openOtherStage(streetNames) );
		
		primaryStage.show();
	}

	
	protected void openOtherStage(List<String> streetNames)
	{
		
		VBox root = new VBox();
		
		//Create a second stage object
		Stage newStage = new Stage();
		
		//Create a scene object to show objects
		Scene newScene = new Scene(root, 500, 500);
		
		//Create a ListView object
		ListView<Number> list = new ListView<>();
		ListView<String> listStr = new ListView<>();
		
		//Create a list of data numbers
		//ObservableList<Number> items = FXCollections.observableArrayList ( 1, 2, 3, 4, 5.5 );
		ObservableList<String> itemStrs = FXCollections.observableArrayList ( streetNames );
		//Give the listView a list of numbers:
		//list.setItems(items);
		listStr.setItems(itemStrs);
		
		root.getChildren().add(listStr);
		
		//Tell the stage which scene to display
		newStage.setScene(newScene);
		
		//make the stage visible
		newStage.show();
	}
	
	/**
	 * Used to read the property tax csv file and store the data to ObservableList<propertyTaxData> propertyTaxData
	 * 
	 * @param filename The string representing a filename to open
	 */
	public List<PropertyTaxData> readPropertyTaxCSVFile(String filename) {
		
		List<PropertyTaxData> propertyTaxData = new ArrayList<>();
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename)))
		{
			String line = "";
			int count = 0;
			while(line != null){
				
				//get a line of text from the file
				line = reader.readLine();
				
				if( line != null) {
					//Split the line by commas
					String [] partsOfLine = line.split(",");
					count++;
					
					//skip column names
					if(count > 1) {
						//The array partsOfLine should now hold everything in the line between commas
						String pid = partsOfLine[0];
						String legal_type = partsOfLine[1];
						String folio = partsOfLine[2];
						String land_coordinate = partsOfLine[3];
						String zone_name = partsOfLine[4];
						String zone_category = partsOfLine[5];
						String lot = partsOfLine[6];
						String block = partsOfLine[7];
						String plan = partsOfLine[8];
						String district_lot = partsOfLine[9];
						String from_civic_number = partsOfLine[10];
						String to_civic_number = partsOfLine[11];
						String street_name = partsOfLine[12];
						String property_postal_code = partsOfLine[13];
						String legalLine1 = partsOfLine[14];
						String legalLine2 = partsOfLine[15];
						String legalLine3 = partsOfLine[16];
						String legalLine4 = partsOfLine[17];
						String legalLine5 = partsOfLine[18];
						long current_land_value = 0;
						if(!partsOfLine[19].equals("")) {
							current_land_value = Long.valueOf(partsOfLine[19]).longValue();
						}
						long current_improvement_value = 0;
						if(!partsOfLine[20].equals("")) {
							current_improvement_value = Long.valueOf(partsOfLine[20]).longValue();
						}
						int tax_assessment_year = 0;
						if(!partsOfLine[21].equals("")) {
							tax_assessment_year = Integer.valueOf(partsOfLine[21]).intValue();
						}
						long previous_land_value = 0;
						if(!partsOfLine[22].equals("")) {
							previous_land_value = Long.valueOf(partsOfLine[22]).longValue();
						}
						long previous_improvement_value = 0;
						if(!partsOfLine[23].equals("")) {
							previous_improvement_value = Long.valueOf(partsOfLine[23]).longValue();
						}
						int year_built = 2015;
						if(!partsOfLine[24].equals("")) {
							year_built = Integer.valueOf(partsOfLine[24]).intValue();
						}
						int big_improvement_year = 0;
						if(!partsOfLine[25].equals("")) {
							big_improvement_year = Integer.valueOf(partsOfLine[25]).intValue();
						}
						double tax_levy = 0.0;
						if(!partsOfLine[26].equals("")) {
							tax_levy = Double.valueOf(partsOfLine[26]).doubleValue();
						}
						String neighbourhood_code = partsOfLine[27];
						
						PropertyTaxData record = new PropertyTaxData(pid, legal_type, folio, land_coordinate, zone_name,
								zone_category, lot, block, plan, district_lot, from_civic_number, to_civic_number, 
								street_name, property_postal_code, legalLine1, legalLine2, legalLine3, legalLine4, 
								legalLine5, current_land_value, current_improvement_value, tax_assessment_year, 
								previous_land_value, previous_improvement_value, year_built, big_improvement_year, tax_levy, neighbourhood_code);
												
						propertyTaxData.add(record);
					}
				}
			}
			
		}catch(IOException ioe)
		{
			System.out.println("Problem reading csv: " + ioe.getMessage());
		}
		return propertyTaxData;
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
