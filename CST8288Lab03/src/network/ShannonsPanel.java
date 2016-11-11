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

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsPanel extends JPanel implements Observer {

	/** max Data Rate JLabel. */
	private JLabel maxDataRateLBL;

	/** ShannonsController instance */
	protected ShannonsController controller;
	/** top ShannonsPanel instance */
	protected ShannonsPanel topPanel;
	/** second ShannonsPanel instance */
	protected ShannonsPanel2 middlePanel;
	/** third ShannonsPanel instance */
	protected ShannonsPanel3 bottomPanel;
	
	/** JTextField for bandwidth */
	public JTextField bandwidthTextField;
	/** JTextField for signal-to-noise ratio */
	public JTextField stnTextField;
	
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default Constructor.
	 */
	public ShannonsPanel()	
	{	
	}
	
	/**
	 *	Constructor.
	 *  @param ctl ShannonsController
	 */
	public ShannonsPanel(ShannonsController ctl)	
	{	
		setController(ctl);
		bandwidthTextField = new JTextField();
		stnTextField = new JTextField();
		initGUI();
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
	 * initGUI create the GUI view
	 */
	private void initGUI() {
		setLayout(new GridLayout(3, 1, 4, 4));
		setMaxDataRateLBL(new JLabel("Maximum data rate via Shannons Theorem = ???"));
		add(maxDataRateLBL);
		add(createBandwidthPanel());
		add(createSignalToNoisePanel());
	}
		
	/**
	 * createBandwidthPanel
	 * @return JPanel BandwidthPanel
	 */
	private JPanel createBandwidthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel label = new JLabel("Bandwidth (in hertz): ");
		panel.add(label);
		panel.add(bandwidthTextField);
		bandwidthTextField.setColumns(20);
		
		bandwidthTextField.addActionListener(event-> {
			String szBandwidth = bandwidthTextField.getText();
			try{
				double bandwidthValue = Double.parseDouble(szBandwidth);
				if( bandwidthValue >= 0 && bandwidthValue <= 3000) {
					controller.setBandwidth(bandwidthValue);
					middlePanel.bandwidthSlider.setValue(Integer.parseInt(szBandwidth));
					bottomPanel.bandwidthComboBox.setSelectedIndex(Integer.parseInt(szBandwidth));
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for bandwidth!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for bandwidth!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		return panel;
	}
	
	/**
	 * createSignalToNoisePanel 
	 * @return JPanel SignalToNoisePanel
	 */
	private JPanel createSignalToNoisePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel label = new JLabel("Signal To Noise (in DB): ");
		panel.add(label);
		panel.add(stnTextField);
		stnTextField.setColumns(20);
		
		stnTextField.addActionListener(event-> {
			String szSignalToNoise = stnTextField.getText();
			try{
				double signalToNoiseValue = Double.parseDouble(szSignalToNoise);
				if( signalToNoiseValue >= 0 && signalToNoiseValue <= 100 ) {
					controller.setSignalToNoise(signalToNoiseValue);
					middlePanel.stnSlider.setValue(Integer.parseInt(szSignalToNoise));
					bottomPanel.stnComboBox.setSelectedIndex(Integer.parseInt(szSignalToNoise));
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for SignalToNoise!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number for SignalToNoise!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		return panel;
	}
						
	/**
	 * Implements Observer update method 
	 * 
	 * @param o observable 
	 * @param arg argument
	 */
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println("start update");
		//System.out.println(arg.toString()); //call ShannonsModel toString() get result
		maxDataRateLBL.setText(arg.toString());
		//System.out.println("update complete");
	}
}
