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
	/** Double used for bandwidth input (hertz). */
	private double bandwidth;
	/** Double used for signal-to-noise ratio input (decibels). */
	private double signalToNoise;
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default construtor.
	 */
	public ShannonsTheorem()	
	{	
	}

	/**
	 *	Paramertized constructor.
	 *	@param	bandWidth      band width of network
	 *  @param  signalToNoise  signalToNoise of network
	 */
	public ShannonsTheorem(double bandWidth, double signalToNoise)	{
		
		setBandwidth(bandWidth);
		
		setSignalToNoise(signalToNoise);
	}

	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 *	Document your getters.
	 */
	//public String getSomeAttribute()						{ return	someAttribute;		}
 
	/**
	 * Get method that returns the bandwidth (hertz).
	 * @return	bandwidth	double containing the bandwidth.
	 */
	public double getBandwidth() { 
		return bandwidth;
	}
	
	/**
	 * Get method that returns the signal-to-noise ratio (decibels).
	 * @return	signalToNoise	double containing the signal-to-noise ratio.
	 */
	public double getSignalToNoise() { 
		return signalToNoise;
	}
	
	/**
	 * Private get method that returns the maximum data rate in bits per second.
	 * @param    hertz    		double to represent bandwidth in hertz.
	 * @param    signalToNoise	double to represent signal-to-noise ratio (decibels).
	 * @return maximum data rate in bits per second as a double.
	 */
	
	private double getMaximumDataRate(double hertz, double signalToNoise) { 
		double result = (hertz *  (Math.log(1+Math.pow(10, signalToNoise/10)) / Math.log(2))); 
		return result;
	}
	
	/**
	 * Get method that returns the result of getMaximumDataRate.
	 * @return maximum data rate in bits per second as a double.
	 */
	public double getMaximumDataRate() { 
		return getMaximumDataRate(bandwidth, signalToNoise);
	}
	
	/**
	 * Set method for bandwidth.
	 * @param    bandwidth    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { this.bandwidth = bandwidth;}
	/**
	 * Set method for signal-to-noise ratio.
	 * @param    signalToNoise   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { this.signalToNoise = signalToNoise;}
	
	/**
	 *	Convert this class to a meaningful string.
	 *	@return	result class as a meaningful string.
	 */
	 public String toString()	{
		 
	     String result = "With a bandwidth of " + getBandwidth() + " hertz and \na signal-to-noise ratio of " + getSignalToNoise() + " decibels\n";
	     result += "using Shannon's Theorem got the Maximum data rate is " + String.format("%.2f",getMaximumDataRate()) + " bits-per-second.";
         
	     return result;
	}

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
		
		JOptionPane.showMessageDialog(null, app, "Result", JOptionPane.PLAIN_MESSAGE);
	}

}	/*	End of CLASS:	ShannonsTheorem.java			*/