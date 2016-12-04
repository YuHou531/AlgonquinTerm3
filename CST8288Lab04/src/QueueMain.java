import mycollections.ArrayListQueue;
import mycollections.EmptyQueueException;
import mycollections.NullObjectException;

/**
 * QueueMain
 * 
 * @author    Yu Hou
 * @version   Nov 20 2016
 *
 */
public class QueueMain {
	
	/**
	 * If arguments exist on the command line enqueue them and dequeue them and terminate
	 * if no arguments, display GUI and take it from there
	 * 
	 * @param args - arguments for input enqueue
	 * @throws EmptyQueueException 
	 */
	public static void main (String args[]) throws EmptyQueueException {
        if(args.length > 0) {
        	System.out.println("Welcome to QueueMain - Yu Hou (Lab 4)");
        	System.out.println("=====================================");
        	
        	ArrayListQueue arrayListQueue = new ArrayListQueue();
        	System.out.println("enqueue from arguments");
        	
    		for ( String arg : args ) {
    			try {
    				arrayListQueue.enqueue( arg );
    			}  catch ( NullObjectException e ) {
    				System.out.println( "argument cannot be null for enqueue" );
    			}
    		}
    		System.out.println("current queue is " + arrayListQueue.getArrayList() );
    		
    		System.out.println("dequeue from arguments");
    		for ( String arg : args ) {
    			arrayListQueue.dequeue();
    			System.out.println("current queue is " + arrayListQueue.getCurrentQueueList());
    		}
    		
    		System.out.println("the end, thanks!");
        }
        else {
        	System.out.println("Welcome to QueueMain - Yu Hou (Lab 4) - GUI part");

        }
	}

  

}
