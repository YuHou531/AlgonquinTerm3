package network;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ShannonsPanel2 extends ShannonsPanel {
		
	public ShannonsPanel2(ShannonsController ctl)	
	{	
		super(ctl);
	}
	
	@Override
	public void initGUI(){
		setLayout(new GridLayout(3, 1, 4, 4));
		setMaxDataRateLBL(new JLabel("Maximum data rate via Shannons Theorem = ???"));
		add(maxDataRateLBL);
		
		add(createSignalToNoisePanel());
		add(createBandwidthPanel());
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

		JSlider bandwidthSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		bandwidthSlider.setMaximum(3000);
		bandwidthSlider.setMinorTickSpacing(50);
		bandwidthSlider.setBounds(116, 11, 235, 43);
		bandwidthSlider.setMajorTickSpacing(1000);
		bandwidthSlider.setPaintTicks(true);
		bandwidthSlider.setPaintLabels(true);
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
		
		JSlider stnSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		stnSlider.setPaintTicks(true);
		stnSlider.setPaintLabels(true);
		stnSlider.setMinorTickSpacing(5);
		stnSlider.setMajorTickSpacing(20);
		panel.add(stnSlider);
		
		return panel;
	}
	


}
