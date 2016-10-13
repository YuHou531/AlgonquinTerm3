/*
 * @(#)ShannonsTheorem.java   1.0 YY/MM/DD
 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 */

/*	Package for class placement	*/
package network;

import javax.swing.JOptionPane;

/**
 * CST8288 OPP with Design Partterns Lab1 B.
 * @author    Yu Hou
 * @version   Sep 12 2016
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