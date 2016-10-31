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
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		setController(ctl);
		controller.addObserver(this);
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
	public void initGUI() {
		JFrame frame = new JFrame("Shannons Theorem MVC Version 1.1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 400, 130);
		
		setMaxDataRateLBL(new JLabel("Maximum data rate via Shannons Theorem = ???"));
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		container.add(maxDataRateLBL);
		container.add(createBandwidthPanel());
		container.add(createSignalToNoisePanel());
				
		frame.getContentPane().add(container);
		frame.setVisible(true);
	}
	
	/**
	 * createSignalToNoisePanel 
	 * @return JPanel SignalToNoisePanel
	 */
	public JPanel createSignalToNoisePanel() {
		JPanel panel = new JPanel();
		JTextField textField = new JTextField();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel label = new JLabel("Signal To Noise (in DB): ");
		panel.add(label);
		
		panel.add(textField);
		textField.setColumns(20);
		
		textField.addActionListener(e-> {
			System.out.println("inside action performed");
			controller.setSignalToNoise(Double.parseDouble(textField.getText()));
		});
		
		return panel;
	}
	
	/**
	 * createBandwidthPanel
	 * @return JPanel BandwidthPanel
	 */
	public JPanel createBandwidthPanel() {
		JPanel panel = new JPanel();
		JTextField textField = new JTextField();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel label = new JLabel("Bandwidth (in hertz): ");
		panel.add(label);
		
		panel.add(textField);
		textField.setColumns(20);

		textField.addActionListener(e-> {
			System.out.println("inside action performed");
			controller.setBandwidth(Double.parseDouble(textField.getText()));
		});
		
		return panel;
	}
	
	/**
	 * Implements Observer update method 
	 * 
	 * @param Observable observable 
	 * @param Object arg
	 */
	public void update(Observable o, Object arg) {
		System.out.println("invoking update");
		//System.out.println(arg);
		System.out.println(arg.toString());
		maxDataRateLBL.setText(arg.toString());
		System.out.println(getMaxDataRateLBL().getText());
		System.out.println("update complete");
	}
	
	
}
