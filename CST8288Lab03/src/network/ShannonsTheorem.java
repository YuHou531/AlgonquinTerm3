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

import javax.swing.JOptionPane;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsTheorem  implements ShannonsController {
	
	/** ShannonsModel instance */
	private ShannonsModel shannonsModel;
	private ShannonsPanel panel1;
	private ShannonsPanel panel2;
	private static ShannonsController controller;
		
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 */
	public ShannonsTheorem()
	{	
		controller = new ShannonsController() {
			
			@Override
			public void setSignalToNoise(double signalToNoiseRatio) {
				this.setSignalToNoise(signalToNoiseRatio);
			}
			
			@Override
			public void setBandwidth(double bandwidth) {
				setBandwidth(bandwidth);
			}
			
			@Override
			public void addObserver(Observer o) {
				addObserver(o);	
			}
		};
		
		shannonsModel = new ShannonsModel();
		panel1 = new ShannonsPanel(this);
		panel2 = new ShannonsPanel(this);
		//Add observer for each panel
		shannonsModel.addObserver(panel1);
		shannonsModel.addObserver(panel2);
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
		ShannonsPanel shannonsPanel = new ShannonsPanel(this);
	}
	
	/**
	 * addObserver 
	 * @param Observer o
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
		
		//Old Code
//		boolean continueValidate = false; 
//		String szBandwidth, szSignalToNoise;
//		
//		ShannonsTheorem app = new ShannonsTheorem();
//		JOptionPane.showMessageDialog(null, "Welcome to Yu Hou's Shannon's Theorem calculator!", "Welcome!", JOptionPane.PLAIN_MESSAGE);
//		
//		do {
//			szBandwidth = JOptionPane.showInputDialog(null, "Please enter the bandwidth.", "Enter hertz", JOptionPane.QUESTION_MESSAGE);
//			try {
//				if( szBandwidth == null ) {
//					JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
//					System.exit(0);
//				}
//				else {
//					double bandwidthValue = Double.parseDouble(szBandwidth);
//					if( bandwidthValue > 0) {
//						app.setBandwidth(bandwidthValue);
//						continueValidate = false;
//					}
//					else {
//						continueValidate = true;
//					}
//				}
//			} catch (NumberFormatException e) {
//				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for bandwidth!", "Error!", JOptionPane.ERROR_MESSAGE);
//				continueValidate = true;
//			}
//		} while (continueValidate);
//		
//		continueValidate = false; 
//		
//		do {
//			szSignalToNoise = JOptionPane.showInputDialog(null, "Please enter the signal-to-noise ratio.", "Enter signal-to-noise ratio", JOptionPane.QUESTION_MESSAGE);
//			try {
//				if( szSignalToNoise == null ) {
//					JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
//					System.exit(0);
//				}
//				else {
//					double signalToNoiseValue = Double.parseDouble(szSignalToNoise);
//					if( signalToNoiseValue > 0) {
//						app.setSignalToNoise(signalToNoiseValue);
//						continueValidate = false;
//					}
//					else {
//						continueValidate = true;
//					}
//				}
//			} catch (NumberFormatException e) {
//				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for SignalToNoise!", "Error!", JOptionPane.ERROR_MESSAGE);
//				continueValidate = true;
//			}
//		} while (continueValidate);
//		
//		JOptionPane.showMessageDialog(null, app.getModel().toString(), "Result", JOptionPane.PLAIN_MESSAGE);
	}

}	/*	End of CLASS:	ShannonsTheorem.java			*/