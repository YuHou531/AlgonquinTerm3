import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.MersenneTwister;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard extends Application {
	
	private Button buttongo;
	private TextField tfMean, tfDeviation, tfN, tfMeanAlter, tfDeviationAlter;
	public int mean,diviation,num;
	private Alert alert = new Alert(AlertType.ERROR);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create a VBox object as the root layout
		VBox root = new VBox();
		root.setSpacing(5);
		primaryStage.setScene(new Scene(root, 800, 150));
		primaryStage.setTitle("CST8284 Lab2");
		
		//The first element in the VBox should be a button with the text label “Go!”.
		buttongo = new Button("Go!");
		buttongo.setMaxWidth(Double.MAX_VALUE);
		
		//The second element should be a text field where a user can enter the mean. By default, it should be 0.
		Label labelMean = new Label ("Enter Mean:  ");
        tfMean = new TextField ("Null Hypothesis");
		tfMean.setPrefWidth(360);
		tfMean.textProperty().addListener((observable, oldValue, newValue) -> {
			//Used for debug
		    //System.out.println("TextField tfMean Changed (newValue: " + newValue + ")");
		    tfMean.setText(newValue);
		});
		
		tfMeanAlter = new TextField ("Alternative");
		tfMeanAlter.setPrefWidth(360);
		tfMeanAlter.textProperty().addListener((observable, oldValue, newValue) -> {
				//Used for debug
			    //System.out.println("TextField tfMean Changed (newValue: " + newValue + ")");
			tfMeanAlter.setText(newValue);
			}); 
		
		
		
		HBox hbMean = new HBox();
		hbMean.getChildren().addAll(labelMean, tfMean,tfMeanAlter);
        
		//The third element should be a text field where a user can enter the variance. By default, it should be 10.
		Label labelDeviation = new Label ("Enter Deviation:  ");
		tfDeviation = new TextField ("Null Hypothesis");
		tfDeviation.setPrefWidth(360);
		tfDeviation.textProperty().addListener((observable, oldValue, newValue) -> {
			//Used for debug
		    //System.out.println("TextField tfDeviation Changed (newValue: " + newValue + ")");
			tfDeviation.setText(newValue);
		});
		
			tfDeviationAlter = new TextField ("Alternative");
			tfDeviationAlter.setPrefWidth(360);
			tfDeviationAlter.textProperty().addListener((observable, oldValue, newValue) -> {
				//Used for debug
			    //System.out.println("TextField tfDeviation Changed (newValue: " + newValue + ")");
				tfDeviationAlter.setText(newValue);
	     
		});
			
		HBox hbDeviation = new HBox();
		hbDeviation.getChildren().addAll(labelDeviation, tfDeviation,tfDeviationAlter);
		
		//The fourth element should be a text field where a user can enter the number of data elements to randomly generate. 
		//Store these numbers that are generated in an ArrayList for later viewing.
		Label labelN = new Label ("Enter N:  ");
		tfN = new TextField ("100");
		tfN.setPrefWidth(743);
		tfN.textProperty().addListener((observable, oldValue, newValue) -> {
			//Used for debug
		    //System.out.println("TextField tfN Changed (newValue: " + newValue + ")");
			tfN.setText(newValue);
		});
		HBox hbN = new HBox();
		hbN.getChildren().addAll(labelN, tfN);
		
		//Add button handlers
		MyHandler responder = new MyHandler();
		buttongo.setOnMousePressed(responder);

		root.getChildren().addAll(buttongo,hbMean,hbDeviation,hbN);
		
		primaryStage.show();	
	}
	
	private class MyHandler implements EventHandler<MouseEvent>
	{
		/*This will handle all mouse clicks*/
		@Override
		public void handle(MouseEvent event) {
			Button clicked = (Button)event.getSource();
			if(clicked == buttongo) {
				//tArea.appendText("You clicked on: " + clicked.getText() +"\n");
				//get the mean
				try {
					mean = Integer.parseInt(tfMean.getText());
				} catch (NumberFormatException e) {
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Mean value Exception");
					alert.setContentText("Please enter Mean value as Integer\nNow we have exception " + e.getMessage());
					alert.showAndWait();
				}
				//get the variance
				try {
					diviation = Integer.parseInt(tfDeviation.getText());
				} catch (NumberFormatException e) {
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Deviation value Exception");
					alert.setContentText("Please enter Deviation value as Integer\nNow we have exception " + e.getMessage());
					alert.showAndWait();
				}
				//get the the number of data elements
				try {
					num = Integer.parseInt(tfN.getText());
				} catch (NumberFormatException e) {
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Number of data elements value Exception");
					alert.setContentText("Please enter number of data elements value as Integer\nNow we have exception " + e.getMessage());
					alert.showAndWait();
				}
				
				//Generate Numbers
		        // Use Java Collections to create the List.
				
				
		        List<Float> myListNums = new ArrayList<Float>();
				for ( int i = num; i>0; i--) {
					In order to generate some data, you will need to use a GaussianRandomGenerator for generating numbers:
					GaussianRandomGenerator rng = new GaussianRandomGenerator(new MersenneTwister());
					float tempRandomeValue = (float)(rng.nextNormalizedDouble()  * (double)diviation + (double)mean);
					myListNums.add(tempRandomeValue);
				}
		        // Now add observability by wrapping it with ObservableList.
			    ObservableList<Float> observableList = FXCollections.observableList(myListNums);
				
				//Do the calculations
				//a.	Maximum
				//b.	Minimum
				//c.	Mean (Average)
				//d.	Weighted Average of the first 10 numbers: 10*list[0] + 9*list[1] … / 55
				//e.	Median
				//f.	Standard Deviation (SD) 
			    float sum = 0.0f;
			    float maxResult = 0.0f;
			    float minResult = 0.0f;
			    float meanResult = 0.0f;
			    float weightedAverage = 0.0f;
			    float median = 0.0f;
			    float sdResult = 0.0f;
			    
                if( myListNums.size() > 0) {
                	maxResult = minResult = myListNums.get(0);
                	
                	for (int i = 0; i<myListNums.size(); i++) {
                		sum += myListNums.get(i);
                		
                		if(maxResult <= myListNums.get(i)) {
                			maxResult = myListNums.get(i);
                		}
                		if(minResult >= myListNums.get(i)) {
                			minResult = myListNums.get(i);
                		}
                	}
                }
                meanResult = sum / myListNums.size();
                
                Collections.sort(myListNums);
                median = myListNums.get( myListNums.size() / 2);	// This is inefficient but works for now

                //Calculate weighted average
                int index = 0;
                float weightedSum = 0.0f;
                for(int j = myListNums.size(); j>0; j--) {
                	weightedSum += j * myListNums.get(index);
                	index ++;
                }
                weightedAverage = weightedSum / (( 1 + myListNums.size()) * myListNums.size() / 2);

				//Calculate SD
                sdResult = (float)Math.sqrt( differenceOfSquares(myListNums, mean) / myListNums.size() );
                
                //final NormalDistribution standardNormal = new NormalDistribution(mean, diviation);

                //double pValue= standardNormal.cumulativeProbability(sdResult);
				//Display in second stage
			    Stage newStage = new Stage();
			    VBox rootSecond = new VBox();
			    
				TextField tf = new TextField();
			    tf.setText(String.format("Mean: %f  Max: %f  Min:%f  SD:%f Median:%f WeightedAverage:%f", meanResult, maxResult, minResult, sdResult, median, weightedAverage));
				
				ListView<Float> list = new ListView<Float>();
				list.setItems(observableList);
								
				rootSecond.getChildren().addAll(tf, list);
				Scene newScene = new Scene(rootSecond, 800,400);
				
				newStage.setScene(newScene);
			    newStage.show();
			}
		}
		
	}
	
	public float differenceOfSquares(List<Float>list, float mean) {
		float sum = 0;
		for(int i = 0; i< list.size(); i++) {
			sum += (list.get(i) - mean) * (list.get(i) - mean);
		}
		return sum; 
	}
	
	public static void main(String args[]) {		
		launch(args);		
	}
}
