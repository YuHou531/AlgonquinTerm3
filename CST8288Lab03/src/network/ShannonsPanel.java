/**
 * This class is the View in the MVC architecture, it has an instance variable
 * of type ShannonsController. 
 * This class implements the java interface Observer making it an object of type
 * Observer, it will observer an observable object (the model).
 * 
 * The Observer interface contains only one method update. Since this class implements
 * the interface Observer, it will provide an implementation for the method defined in
 * the interface it implements. 
 * 
 * The view notifies the controller of updates to "its" data. The controller in turn 
 * will then update the model, the model will then notify all registered observers 
 * of the change by invoking the update() method.
 * 
 * maxDataRateLBL is a private attribute in ShannonsPanel
 */
package network;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsPanel implements Observer{

	private JLabel maxDataRateLBL;
	private ShannonsController controller;
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 */
	public ShannonsPanel(ShannonsController ctl)	
	{	
		controller = ctl;
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 * getMaxDataRateLBL 
	 * @return current maxDataRateLBL
	 */
	public JLabel getMaxDataRateLBL() {
		return maxDataRateLBL;
	}
	
	/**
	 * setMaxDataRateLBL
	 * @param mdrlbl JLabel 
	 */
	public void setMaxDataRateLBL(JLabel mdrlbl) {
		maxDataRateLBL = mdrlbl;
	}
	
	/**
	 * Set ShannonsController
	 * @param ctl ShannonsController
	 */
	public void setController(ShannonsController ctl) {
		controller = ctl;
	}
	
	/**
	 * intGUI method
	 */
	public void intGUI() {
		
	}
	
	/**
	 * createSignalToNoisePanel 
	 * @return JPanel SignalToNoisePanel
	 */
	public JPanel createSignalToNoisePanel() {
		
		return null;
	}
	
	/**
	 * createBandwidthPanel
	 * @return JPanel BandwidthPanel
	 */
	public JPanel createBandwidthPanel() {
		
		return null;
	}
	
	/**
	 * Implements Observer update method 
	 * 
	 * @param Observable observable 
	 * @param Object arg
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
