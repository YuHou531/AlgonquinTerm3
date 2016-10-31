/**
 * This is an interface. It defines the operations(methods) available 
 * in the controller.
 * 
 * Interfaces are said to be "pure abstract classes". They contain only
 * externally visible (public) operations without any implementation. 
 * They contain only method definitions, no instance variables. 
 * This makes an interface difinitoin only.
 */
package network;

import java.util.Observer;

/**
 * CST8288 OPP with Design Patterns Lab3.
 * @author    Yu Hou
 * @version   Oct 30 2016
 */
public interface ShannonsController {
	public void addObserver(Observer o);
	public void setBandwidth(double bandwidth);
	public void setSignalToNoise(double signalToNoiseRatio);
}
