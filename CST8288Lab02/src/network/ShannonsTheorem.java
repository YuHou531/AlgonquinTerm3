/*
 * @(#)ShannonsTheorem.java   1.0
 *
 * The main class, ShannonsTheorem has an association with the model
 * class. ShannosModel. The role name on the diagram indicates that the code
 * should have a reference attribute named "model" of type ShannosModel
 * 
 * The new version of the ShannonsTheorem class, now contains the "view"
 * and the "controller" component
 * 
 * It no longer contains the "model"
 */

/*	Package for class placement	*/
package network;

import javax.swing.JOptionPane;

/**
 * CST8288 OPP with Design Partterns Lab2.
 * @author    Yu Hou
 * @version   Oct 12 2016
 */
public class ShannonsTheorem {
	
	/** ShannonsModel instance */
	private ShannonsModel shannonsModel;
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default construtor.
	 */
	public ShannonsTheorem()
	{	
		shannonsModel = new ShannonsModel();
	}

	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 * Get method that returns the bandwidth (hertz) of the ShannonsModel instance
	 * @return	bandwidth	double containing the bandwidth.
	 */
	public double getBandwidth() { 
		return shannonsModel.getBandwidth();
	}
	
	/**
	 * Get method that returns the signal-to-noise ratio (decibels) of the ShannonsModel instance
	 * @return	signalToNoise	double containing the signal-to-noise ratio.
	 */
	public double getSignalToNoise() { 
		return shannonsModel.getSignalToNoise();
	}
	
	/**
	 * Get method that returns the ShannonsModel instance
	 * @return	shannonsModel	current ShannonsModel instance
	 */
	public ShannonsModel getShannonsModel() {
		return shannonsModel;
	}
		
	/**
	 * Get method that returns the result of maximumDataRate of the ShannonsModel instance
	 * @return maximum data rate in bits per second as a double.
	 */
	public double maximumDataRate() { 
		return shannonsModel.maximumDataRate();
	}
	
	/**
	 * Set method for bandwidth for ShannonsModel instance
	 * @param    bandwidth    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { shannonsModel.setBandwidth(bandwidth);}
	/**
	 * Set method for signal-to-noise ratio for ShannonsModel instance
	 * @param    signalToNoise   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { shannonsModel.setSignalToNoise(signalToNoise);}
	
	/*	ENTRY POINT for STAND-ALONE OPERATION ---------------------------	*/
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a
	 *	string array.
	 */
	public static void main (String args[]) {
		boolean continueValidate = false; 
		String szBandwidth, szSignalToNoise;
		
		ShannonsTheorem app = new ShannonsTheorem();
		JOptionPane.showMessageDialog(null, "Welcome to Yu Hou's Shannon's Theorem calculator!", "Welcome!", JOptionPane.PLAIN_MESSAGE);
		
		do {
			szBandwidth = JOptionPane.showInputDialog(null, "Please enter the bandwidth.", "Enter hertz", JOptionPane.QUESTION_MESSAGE);
			try {
				if( szBandwidth == null ) {
					JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					double bandwidthValue = Double.parseDouble(szBandwidth);
					if( bandwidthValue > 0) {
						app.setBandwidth(bandwidthValue);
						continueValidate = false;
					}
					else {
						continueValidate = true;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for bandwidth!", "Error!", JOptionPane.ERROR_MESSAGE);
				continueValidate = true;
			}
		} while (continueValidate);
		
		continueValidate = false; 
		
		do {
			szSignalToNoise = JOptionPane.showInputDialog(null, "Please enter the signal-to-noise ratio.", "Enter signal-to-noise ratio", JOptionPane.QUESTION_MESSAGE);
			try {
				if( szSignalToNoise == null ) {
					JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else {
					double signalToNoiseValue = Double.parseDouble(szSignalToNoise);
					if( signalToNoiseValue > 0) {
						app.setSignalToNoise(signalToNoiseValue);
						continueValidate = false;
					}
					else {
						continueValidate = true;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for SignalToNoise!", "Error!", JOptionPane.ERROR_MESSAGE);
				continueValidate = true;
			}
		} while (continueValidate);
		
		JOptionPane.showMessageDialog(null, app.getShannonsModel().toString(), "Result", JOptionPane.PLAIN_MESSAGE);
	}

}	/*	End of CLASS:	ShannonsTheorem.java			*/