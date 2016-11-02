package network;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ShannonsPanel2 extends ShannonsPanel {
	
	public JSlider bandwidthSlider;
	public JSlider stnSlider;
		
	public ShannonsPanel2(ShannonsController ctl)	
	{	
		super(ctl);
		bandwidthSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
		stnSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
	}
	
	@Override
	public void initGUI(){
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
	@Override
	public JPanel createBandwidthPanel() {
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
	@Override
	public JPanel createSignalToNoisePanel() {
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
}
