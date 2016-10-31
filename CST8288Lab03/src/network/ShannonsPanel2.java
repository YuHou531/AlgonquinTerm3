package network;

import java.awt.GridLayout;

import javax.swing.JLabel;

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
	


}
