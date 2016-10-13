import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard extends Application {
	
	@Override 
	public void start(Stage stage) {
		
        GridPane root = new GridPane();
        root.add( getPieChart(), 0, 0);
		root.add( getBubbleChart(), 1, 0);
		root.add( getScatterChart(), 0, 1);
		root.add( getLineChart(), 1, 1);
		
		Scene scene = new Scene(root, 1024, 768);   
		stage.setScene(scene);
        stage.show();
	}
	
	//Pie Char
	public PieChart getPieChart() {
		
	    ObservableList<PieChart.Data> pieChartData =
	    		FXCollections.observableArrayList(
	    				new PieChart.Data("Grapefruit", 13),
		                new PieChart.Data("Oranges", 25),
		                new PieChart.Data("Plums", 10),
		                new PieChart.Data("Pears", 22),
		                new PieChart.Data("Apples", 30),
	                    new PieChart.Data("Watermelons", 30));
	    final PieChart chart = new PieChart(pieChartData);
	    chart.setTitle("Imported Fruits");
	   	    
	    return chart; 
	}
	
	//Line chart
	public LineChart<Number,Number> getLineChart() {
		final NumberAxis xAxis = new NumberAxis();
	    final NumberAxis yAxis = new NumberAxis();
	    xAxis.setLabel("Number of Month");
	        
		final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
		lineChart.setTitle("Stock Monitoring, 2010");
		
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25)); 
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("My New Line");
        series1.getData().add(new XYChart.Data(1, 20));
        series1.getData().add(new XYChart.Data(2, 11));
        series1.getData().add(new XYChart.Data(3, 12));
        series1.getData().add(new XYChart.Data(4, 21));
        series1.getData().add(new XYChart.Data(5, 31));
        series1.getData().add(new XYChart.Data(6, 33));
        series1.getData().add(new XYChart.Data(7, 19));
        series1.getData().add(new XYChart.Data(8, 42));
        series1.getData().add(new XYChart.Data(9, 40));
        series1.getData().add(new XYChart.Data(10, 14));
        series1.getData().add(new XYChart.Data(11, 26));
        series1.getData().add(new XYChart.Data(12, 22)); 
        
        
        lineChart.getData().addAll(series,series1);
        
        return lineChart;
	}
	
	//Scatter Chart
	public ScatterChart<Number,Number> getScatterChart() {
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<>(xAxis,yAxis);
        xAxis.setLabel("Age (years)");                
        yAxis.setLabel("Returns to date");
        sc.setTitle("Investment Overview");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Equities");
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        series1.getData().add(new XYChart.Data(2.8, 33.6));
        series1.getData().add(new XYChart.Data(6.2, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.2, 26.4));
        series1.getData().add(new XYChart.Data(4.4, 114.4));
        series1.getData().add(new XYChart.Data(8.5, 323));
        series1.getData().add(new XYChart.Data(6.9, 289.8));
        series1.getData().add(new XYChart.Data(9.9, 287.1));
        series1.getData().add(new XYChart.Data(0.9, -9));
        series1.getData().add(new XYChart.Data(3.2, 150.8));
        series1.getData().add(new XYChart.Data(4.8, 20.8));
        series1.getData().add(new XYChart.Data(7.3, -42.3));
        series1.getData().add(new XYChart.Data(1.8, 81.4));
        series1.getData().add(new XYChart.Data(7.3, 110.3));
        series1.getData().add(new XYChart.Data(2.7, 41.2));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Mutual funds");
        series2.getData().add(new XYChart.Data(5.2, 229.2));
        series2.getData().add(new XYChart.Data(2.4, 37.6));
        series2.getData().add(new XYChart.Data(3.2, 49.8));
        series2.getData().add(new XYChart.Data(1.8, 134));
        series2.getData().add(new XYChart.Data(3.2, 236.2));
        series2.getData().add(new XYChart.Data(7.4, 114.1));
        series2.getData().add(new XYChart.Data(3.5, 323));
        series2.getData().add(new XYChart.Data(9.3, 29.9));
        series2.getData().add(new XYChart.Data(8.1, 287.4));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Investment");
        series3.getData().add(new XYChart.Data(4, 29.2));
        series3.getData().add(new XYChart.Data(2, 7.6));
        series3.getData().add(new XYChart.Data(3, 4.8));
        series3.getData().add(new XYChart.Data(8, 34));
        series3.getData().add(new XYChart.Data(2, 26.2));
        series3.getData().add(new XYChart.Data(4, 14.1));
        series3.getData().add(new XYChart.Data(5, 32));
        series3.getData().add(new XYChart.Data(3, 2.9));
        series3.getData().add(new XYChart.Data(1, 28.4));
        sc.getData().addAll(series1, series2, series3);
        
        return sc;
	}
	
	//Bubble chart
    public BubbleChart<Number,Number> getBubbleChart(){
    	 final NumberAxis xAxis = new NumberAxis(1, 53, 4);
         final NumberAxis yAxis = new NumberAxis(0, 80, 10);
         final BubbleChart<Number,Number> blc = new
             BubbleChart<>(xAxis,yAxis);
         xAxis.setLabel("Week");
         yAxis.setLabel("Product Budget");
         blc.setTitle("Budget Monitoring");
        
         XYChart.Series series1 = new XYChart.Series();
         series1.setName("Product 1");
         series1.getData().add(new XYChart.Data(3, 35));
         series1.getData().add(new XYChart.Data(12, 60));
         series1.getData().add(new XYChart.Data(15, 15));
         series1.getData().add(new XYChart.Data(22, 30));
         series1.getData().add(new XYChart.Data(28, 20));
         series1.getData().add(new XYChart.Data(35, 41));
         series1.getData().add(new XYChart.Data(42, 17));
         series1.getData().add(new XYChart.Data(49, 30));
                 
         XYChart.Series series2 = new XYChart.Series();
         series2.setName("Product 2");
         series2.getData().add(new XYChart.Data(8, 15));
         series2.getData().add(new XYChart.Data(13, 23));
         series2.getData().add(new XYChart.Data(15, 45));
         series2.getData().add(new XYChart.Data(24, 30));
         series2.getData().add(new XYChart.Data(38, 78));
         series2.getData().add(new XYChart.Data(40, 41));
         series2.getData().add(new XYChart.Data(45, 57));
         series2.getData().add(new XYChart.Data(47, 23));
         
         XYChart.Series series3 = new XYChart.Series();
         series3.setName("Product 3");
         series3.getData().add(new XYChart.Data(5, 10));
         series3.getData().add(new XYChart.Data(10, 18));
         series3.getData().add(new XYChart.Data(12, 40));
         series3.getData().add(new XYChart.Data(21, 25));
         series3.getData().add(new XYChart.Data(35, 73));
         series3.getData().add(new XYChart.Data(37, 36));
         series3.getData().add(new XYChart.Data(42, 52));
         series3.getData().add(new XYChart.Data(42, 18));
         blc.getData().addAll(series1, series2, series3);  
         
         return blc;
    }
	
	public static void main(String[] args) {
        launch(args);
    }

}
