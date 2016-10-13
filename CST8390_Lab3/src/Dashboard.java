import java.util.ArrayList;
import org.apache.commons.math3.distribution.NormalDistribution;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard extends Application {
	
	private Button buttongo;
	private TextField tfMean, tfDeviation, tfN, tfMeanAlter, tfDeviationAlter;
	public double mean,diviation,mu2,sigma2;
	public int num;
	private Alert alert = new Alert(AlertType.ERROR);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create a VBox object as the root layout
		VBox root = new VBox();
		root.setSpacing(5);
		primaryStage.setScene(new Scene(root, 800, 150));
		primaryStage.setTitle("CST8284 Lab3");
		
		//The first element in the VBox should be a button with the text label 
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
				
				//get mean 2
				 mu2 = Double.parseDouble(tfMeanAlter.getText());
				//get sigma2
				 sigma2 = Double.parseDouble(tfDeviationAlter.getText());
				 
				 NormalDistribution ndNull= new NormalDistribution(mean,diviation);
				 NormalDistribution ndAlt=new NormalDistribution(mu2,sigma2);
				 ArrayList<Double> set1= new ArrayList<>();
				 ArrayList<Double> set2= new ArrayList<>();
				 
				 double pValue=ndNull.cumulativeProbability(mu2);
				
				//Display in second stage
			    Stage newStage = new Stage();
			    VBox rootSecond = new VBox();
			    
				TextField tf = new TextField();
			    tf.setText(String.format("Mean1: %f  Sigma1: %f  Mean2:%f  p-value:%f" , mean, diviation, mu2, pValue));
			    NumberAxis xAxis = new NumberAxis();
			    NumberAxis yAxis = new NumberAxis();
			    
			    xAxis.setLabel("Number of Month");
			    
			    //creating the chart
			    final LineChart<Number,Number> lineChart= new LineChart<>(xAxis,yAxis);
			    lineChart.setTitle("Deviation of 2 data sets");
			    
			    //define a series
			    XYChart.Series series=new XYChart.Series();
			    series.setName("Set1");
			    
			    //populating the series with data
			    double lower = ndNull.getMean() - (3* ndNull.getStandardDeviation());
			    double upper = ndNull.getMean() + (3* ndNull.getStandardDeviation());
			    
			    for(double i = lower;	 i < upper;	i += (upper-lower) / 30 )
				{    
			    	series.getData().add(new XYChart.Data(i, ndNull.density(i)));      
			    }

			    //define a series2
			    XYChart.Series series2 = new XYChart.Series();
			    series2.setName("Set2");
			    
			    //populating the series with data
			    lower = ndAlt.getMean() - (3* ndAlt.getStandardDeviation());
			    upper = ndAlt.getMean() + (3* ndAlt.getStandardDeviation());
			    
			    for(double i = lower; i < upper;	i += (upper-lower) / 30 )
				{    
			    	series2.getData().add(new XYChart.Data(i, ndAlt.density(i)));      
			    }
			    
			    lineChart.getData().addAll(series,series2);
			    
			    if ( pValue > 0.025 && pValue < 0.975 ){
			    	Node line = series.getNode().lookup(".chart-series-line");       
			    	line.setStyle("-fx-stroke: #0000FFFF;-fx-stroke-width: 10px;");

			        Node line2 = series2.getNode().lookup(".chart-series-line");       
			        line2.setStyle("-fx-stroke: #FF0000B0;-fx-stroke-width: 2px;"); 
			    }
			    else
			    {
			    	Node line = series.getNode().lookup(".chart-series-line");        
			    	line.setStyle("-fx-stroke: #FF00FFB0;-fx-stroke-width: 2px;");

			        Node line2 = series2.getNode().lookup(".chart-series-line");        
			        line2.setStyle("-fx-stroke: #00FF00FF;-fx-stroke-width: 10px;");
			    }
			    								
				rootSecond.getChildren().addAll(tf,lineChart);
				Scene newScene = new Scene(rootSecond, 800,400);
				
				newStage.setScene(newScene);
			    newStage.show();
			}
		}
		
	}
	
	public static void main(String args[]) {		
		launch(args);		
	}
}
