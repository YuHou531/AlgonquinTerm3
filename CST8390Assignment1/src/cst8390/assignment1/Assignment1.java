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
	
	public static void main(String[] args) {
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
	
	
	/**  This is the basic parts of reading a CSV file.
	 * 
	 * @param filename The string representing a filename to open.
	 */
	public void readCSVFile(String filename)
	{
		
		try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename)))
		{
			String line = "";
			while(line != null){
				
				//get a line of text from the file
				line = reader.readLine();
				
				//Split the line by commas
				String [] partsOfLine = line.split(",");
				
				
				//The array partsOfLine should now hold everything in the line between commas
				String first = partsOfLine[0];
				String second = partsOfLine[1];
				String third = partsOfLine[2];
			}
			
		}catch(IOException ioe)
		{
			System.out.println("Problem reading csv: " + ioe.getMessage());
		}
	}

}
