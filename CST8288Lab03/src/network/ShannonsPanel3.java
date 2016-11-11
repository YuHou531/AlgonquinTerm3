package network;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public class ShannonsPanel3 extends ShannonsPanel {
	
	/** max Data Rate JLabel. */
	private JLabel maxDataRateLBL;
	
	/** JComboBox for bandwidth */
	public JComboBox bandwidthComboBox;
	/** JComboBox for signal-to-noise ratio */
	public JComboBox stnComboBox;

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**
	 *	Default constructor.
	 *  @param ctl ShannonsController
	 */
	public ShannonsPanel3(ShannonsController ctl)	
	{	
		setController(ctl);
		bandwidthComboBox = new JComboBox<String>();
		stnComboBox = new JComboBox<String>();
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

		/* Sets the integer range for the bandwidthComboBox */
		int counter = 0;
		String[] bandwidthSelection = new String[3001];
		do {
			bandwidthSelection[counter] = Integer.toString(counter);
			counter++;
		} while (counter <= 3000);
		
		bandwidthComboBox.setBounds(118, 25, 235, 20);
		bandwidthComboBox.setModel(new DefaultComboBoxModel<String>(bandwidthSelection));
		bandwidthComboBox.setSelectedItem(bandwidthSelection[3000]);
		
		bandwidthComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					controller.setBandwidth(bandwidthComboBox.getSelectedIndex());
					topPanel.bandwidthTextField.setText(String.valueOf(bandwidthComboBox.getSelectedIndex()));
					middlePanel.bandwidthSlider.setValue(bandwidthComboBox.getSelectedIndex());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		panel.add(bandwidthComboBox);
		
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
		
		/* Sets the integer range for the stnComboBox */
		int counter = 0;
		String[] stnSelection = new String[101];
		do {
			stnSelection[counter] = Integer.toString(counter);
			counter++;
		} while (counter <= 100);
		
		stnComboBox.setBounds(118, 55, 235, 20);
		stnComboBox.setModel(new DefaultComboBoxModel<String>(stnSelection));
		stnComboBox.setSelectedItem(stnSelection[100]);
		
		stnComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					controller.setSignalToNoise(stnComboBox.getSelectedIndex());
					topPanel.stnTextField.setText(String.valueOf(stnComboBox.getSelectedIndex()));
					middlePanel.stnSlider.setValue(stnComboBox.getSelectedIndex());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		panel.add(stnComboBox);
		
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
