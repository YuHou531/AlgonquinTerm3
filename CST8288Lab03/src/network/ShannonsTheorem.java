/**
 * A class that implements an interface "realizes" the interface (as
 * we say in UML). it provides an implementation for the methods defined in 
 * the interface (or it will defer the implementation to a child class(subclass))
 * Realization is like a generalization line except the line is a dashed line.
 * 
 * As in the previous exercise, this class implemented the delegate pattern.
 * for example, it delegates the getBandwidth() operation to the model class
 * by invoking getModel().getBandwidth()
 * 
 */

/*	Package for class placement	*/
package network;

import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsTheorem  implements ShannonsController {
	
	/** 
	 * ShannonsModel instance 
	 */
	private ShannonsModel shannonsModel;
	
	/**
	 * ShannonsController
	 */
	private ShannonsController controller;
	
	/**
	 * ShannonsPanel panels
	 */
	public ShannonsPanel panel1;
	public ShannonsPanel2 panel2;
	public ShannonsPanel3 panel3;
			
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 */
	public ShannonsTheorem()
	{	
		shannonsModel = new ShannonsModel();
		
		controller = new ShannonsController() {
			@Override
			public void setSignalToNoise(double signalToNoiseRatio) {
				getModel().setSignalToNoise(signalToNoiseRatio);
			}
			
			@Override
			public void setBandwidth(double bandwidth) {
				getModel().setBandwidth(bandwidth);
			}
			
			@Override
			public void addObserver(Observer o) {
				getModel().addObserver(o);	
			}
		};
		
		panel1 = new ShannonsPanel(controller);
		panel1.initGUI();
		panel2 = new ShannonsPanel2(controller);
		panel2.initGUI();
		panel3 = new ShannonsPanel3(controller);
		panel3.initGUI();
		getModel().addObserver(panel1);
		getModel().addObserver(panel2);
		getModel().addObserver(panel3);
		
		//So that we can update different panels
		panel1.topPanel = panel1;
		panel1.middlePanel = panel2;
		panel1.bottomPanel = panel3;
		
		panel2.topPanel = panel1;
		panel2.middlePanel = panel2;
		panel2.bottomPanel = panel3;
		
		panel3.topPanel = panel1;
		panel3.middlePanel = panel2;
		panel3.bottomPanel = panel3;
	}

	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 * Get method that returns the ShannonsModel instance
	 * @return	shannonsModel	current ShannonsModel instance
	 */
	public ShannonsModel getModel() {
		return shannonsModel;
	}
	
	/**
	 * Get method that returns the bandwidth (hertz) of the ShannonsModel instance
	 * @return	bandwidth	double containing the bandwidth.
	 */
	public double getBandwidth() { 
		return getModel().getBandwidth();
	}
	
	/**
	 * Get method that returns the result of maximumDataRate of the ShannonsModel instance
	 * @return maximum data rate in bits per second as a double.
	 */
	public double getMaximumDataRate() { 
		return getModel().getMaximumDataRate();
	}
	
	/**
	 * Get method that returns the signal-to-noise ratio (decibels) of the ShannonsModel instance
	 * @return	signalToNoise	double containing the signal-to-noise ratio.
	 */
	public double getSignalToNoise() { 
		return getModel().getSignalToNoise();
	}
	
	/**
	 * Set method for signal-to-noise ratio for ShannonsModel instance
	 * @param    signalToNoise   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { 
		getModel().setSignalToNoise(signalToNoise);
	}
	
	/**
	 * Set method for setting ShannonsModel instance
	 * @param model ShannonsModel instance
	 */
	public void setModel(ShannonsModel model) {
		shannonsModel = model;
	}
	
	/**
	 * Set method for bandwidth for ShannonsModel instance
	 * @param    bandwidth    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { 
		getModel().setBandwidth(bandwidth);
	}

	/**
	 * initGUI create the GUI view
	 */
	public void initGUI() {
		
		JFrame frame = new JFrame("Shannons Theorem MVC Version 1.1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		container.add(panel1);
		container.add(separator1);
		container.add(panel2);
		container.add(separator2);
		container.add(panel3);
		
		frame.getContentPane().add(container);
		frame.pack();
		frame.setVisible(true);		
	}
	
	/**
	 * addObserver 
	 * @param o Observer
	 */
	public void addObserver(Observer o) {
		getModel().addObserver(o);
	}
	
	/*	ENTRY POINT for STAND-ALONE OPERATION ---------------------------	*/
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a
	 *	string array.
	 */
	public static void main (String args[]) {
		ShannonsTheorem app = new ShannonsTheorem();
		app.initGUI();
	}

}	/*	End of CLASS:	ShannonsTheorem.java			*/