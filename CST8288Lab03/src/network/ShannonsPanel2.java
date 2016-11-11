package network;

import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsPanel2 extends ShannonsPanel {
	
	/** max Data Rate JLabel. */
	private JLabel maxDataRateLBL;
	
	/** JSlider for bandwidth */
	public JSlider bandwidthSlider;
	/** JSlider for signal-to-noise ratio */
	public JSlider stnSlider;
		
	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 *  @param ctl ShannonsController
	 */
	public ShannonsPanel2(ShannonsController ctl)	
	{	
		setController(ctl);
		bandwidthSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		stnSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		initGUI();
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/
	/**
	 * getMaxDataRateLBL 
	 * @return current maxDataRateLBL
	 */
	@Override
	public JLabel getMaxDataRateLBL() {
		return maxDataRateLBL;
	}
	
	/**
	 * setMaxDataRateLBL
	 * @param mdrlbl JLabel 
	 */
	@Override
	public void setMaxDataRateLBL(JLabel mdrlbl) {
		maxDataRateLBL = mdrlbl;
	}
	
	/**
	 * initGUI create the GUI view
	 */
	private void initGUI(){
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
		
		JLabel bandwidthLabel = new JLabel("Bandwidth (in hertz): ");
		panel.add(bandwidthLabel);

		bandwidthSlider.setMaximum(3000);
		bandwidthSlider.setMinorTickSpacing(50);
		bandwidthSlider.setBounds(116, 11, 235, 43);
		bandwidthSlider.setMajorTickSpacing(1000);
		bandwidthSlider.setPaintTicks(true);
		bandwidthSlider.setPaintLabels(true);
		
		bandwidthSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				try {
					controller.setBandwidth(bandwidthSlider.getValue());
					topPanel.bandwidthTextField.setText(String.valueOf(bandwidthSlider.getValue()));
					bottomPanel.bandwidthComboBox.setSelectedIndex(bandwidthSlider.getValue());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		panel.add(bandwidthSlider);
		
		return panel;
	}
	
	/**
	 * createSignalToNoisePanel 
	 * @return JPanel SignalToNoisePanel
	 */
	private JPanel createSignalToNoisePanel() {
		JPanel panel = new JPanel();
		
		JLabel signalToNoiseLabel  = new JLabel("Signal To Noise (in DB): ");
		panel.add(signalToNoiseLabel);
		
		stnSlider.setPaintTicks(true);
		stnSlider.setPaintLabels(true);
		stnSlider.setMinorTickSpacing(5);
		stnSlider.setMajorTickSpacing(20);
		
		stnSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				try {
					controller.setSignalToNoise(stnSlider.getValue());
					topPanel.stnTextField.setText(String.valueOf(stnSlider.getValue()));
					bottomPanel.stnComboBox.setSelectedIndex(stnSlider.getValue());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		panel.add(stnSlider);
		
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
