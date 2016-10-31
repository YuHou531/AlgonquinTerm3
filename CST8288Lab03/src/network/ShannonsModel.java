/**
 * This is the "observable" object, the model. 
 * This class extends the java class "Observable" making it not only 
 * an object of type ShannonsModel but also an object of type Observable
 * 
 * This object is under observation by the registered observers.
 */

/*	Package for class placement	*/
package network;

import java.util.Observable;

/**
 * CST8288 OPP with Design Partterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsModel extends Observable {
	
	/** Double used for bandwidth input (hertz). */
	private double bandwidth;
	/** Double used for signal-to-noise ratio input (decibels). */
	private double signalToNoise;
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default construtor.
	 */
	public ShannonsModel()	
	{	
	}
		
	/* ACCESSORS	-----------------------------------------------------	*/
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
	 * Get method that returns the result of maximumDataRate.
	 * @return maximum data rate in bits per second as a double.
	 */
	public double getMaximumDataRate() { 
		return maximumDataRate(bandwidth, signalToNoise);
	}
		
	/**
	 * Private get method that returns the maximum data rate in bits per second.
	 * @param    hertz    		double to represent bandwidth in hertz.
	 * @param    signalToNoise	double to represent signal-to-noise ratio (decibels).
	 * @return maximum data rate in bits per second as a double.
	 */
	private double maximumDataRate(double hertz, double signalToNoise) { 
		double result = (hertz *  (Math.log(1+Math.pow(10, signalToNoise/10)) / Math.log(2))); 
		return result;
	}
		
	/**
	 * Set method for bandwidth.
	 * @param    bandwidth    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { 
		this.bandwidth = bandwidth;
	}
	
	/**
	 * Set method for signal-to-noise ratio.
	 * @param    signalToNoise   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { 
		this.signalToNoise = signalToNoise;
	}
	
	/**
	 *	Convert this class to a meaningful string.
	 *	@return	result class as a meaningful string.
	 */
	 public String toString()	{
		 
	     String result = "With a bandwidth of " + getBandwidth() + " hertz and \na signal-to-noise ratio of " + getSignalToNoise() + " decibels\n";
	     result += "using Shannon's Theorem got the Maximum data rate is " + String.format("%.2f",getMaximumDataRate()) + " bits-per-second.";
         
	     return result;
	}
}
