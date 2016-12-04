package testcollections;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.*;
import mycollections.ArrayListQueue;
import mycollections.EmptyQueueException;
import mycollections.NullObjectException;

/**
 * JUnit tests for the ArrayListQueue
 * @author  Yu Hou
 * @version 1.0.0
 */
public class Test_ArrayrListQueue extends TestCase {
	
	public Test_ArrayrListQueue(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ArrayrListQueue.class); }

	protected void setUp() throws Exception { System.out.println("Test_ArrayrListQueue Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ArrayrListQueue End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
		
      System.out.println("\tExecuting Test_ArrayrListQueue.testConstructors");
      
      arrayListQueue = new ArrayListQueue();
	  assertNotNull("\t\tTest_ArrayrListQueue.testConstructors: arrayListQueue is not null", arrayListQueue);
	}
	
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
      System.out.println("\tExecuting Test_ArrayrListQueue.testAccessors");
      
      arrayListQueue = new ArrayListQueue();
  	  ArrayList arraylist = arrayListQueue.getArrayList();
  	  assertNotNull("\t\tTest_ArrayrListQueue.testAccessors: arraylist is not null", arraylist);
  	
  	  ArrayList currentQueueList = arrayListQueue.getCurrentQueueList();
  	  assertNotNull("\t\tTest_ArrayrListQueue.testAccessors: currentQueueList is not null", arraylist);
  	
  	  Iterator iterator = arrayListQueue.iterator();
  	  assertNotNull("\t\tTest_ArrayrListQueue.testAccessors: iterator is not null", arraylist);		
	}
	
	/**
	 * Test behaviors.
	 * @throws NullObjectException 
	 * @throws EmptyQueueException 
	 */
	public void testBehaviors() throws NullObjectException, EmptyQueueException {
		System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors");
		
		arrayListQueue = new ArrayListQueue();
		arrayListQueue2 = new ArrayListQueue();
		
		//test enqueue and test size of queue
		//add 5 to the queue (5)
		//add null to the queue throws NullObjectException
		System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test enqueue a number");
		assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test enqueue a number ", arrayListQueue.enqueue(5) == true );
		
		System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test enqueue null return NullObjectException");
        try {
        	arrayListQueue.enqueue(null);
        } catch (NullObjectException e) {
            assertEquals(e.getMessage(), "cannot add null to the queue");
        }
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test size ", arrayListQueue.size() == 1 );
        
        //test peek and test size
        //(5)
        // add 3 to the queue
        //(5,3)
        System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test peek");
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test peek ", (int)arrayListQueue.peek() == 5 );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test size ", arrayListQueue.size() == 1 );
        arrayListQueue.enqueue(3);
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test peek ", (int)arrayListQueue.peek() == 5 );
        assertFalse("\t\tTest_ArrayrListQueue.testBehaviors - test peek ", (int)arrayListQueue.peek() == 3 );
        
        System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test peek for empty queue return EmptyQueueException");
        try {
        	arrayListQueue2.peek();
        } catch (EmptyQueueException e) {
            assertEquals(e.getMessage(), "queue is empty");
        }
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test size ", arrayListQueue.size() == 2 );
        
        //test dequeue and test size
        //(5,3)
        //dequeue will change queue as (3) => first in first out
        //dequeue again will change queue as () => first in first out
        //dequeue again will throw EmptyQueueException
        System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test dequeue");
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test dequeue ", (int)arrayListQueue.dequeue() == 5 );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test size ", arrayListQueue.size() == 1 );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test peek again after dequeue", (int)arrayListQueue.peek() == 3 );
        assertFalse("\t\tTest_ArrayrListQueue.testBehaviors - test peek again after dequeue", (int)arrayListQueue.peek() == 5 );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test dequeue ", (int)arrayListQueue.dequeue() == 3 );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test size ", arrayListQueue.size() == 0 );
        
        System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test dequeue for empty queue return EmptyQueueException");
        try {
        	arrayListQueue.dequeue();
        } catch (EmptyQueueException e) {
            assertEquals(e.getMessage(), "queue is empty");
        }
        
        //test iterator / remove / contains / hasNext / next
        //initial state now arraylist (5, 3)    queue ()
        //enqueue 5, 6, 7 => arraylist (5, 3, 5, 6, 7)   queue (5, 6, 7)
        //check queue contains(5)
        //remove 5 from queue => arraylist (5, 3, 6, 7)  queue (6, 7)
        System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test iterator / remove / contains / hasNext / next");
        arrayListQueue.enqueue(5);
        arrayListQueue.enqueue(6);
        arrayListQueue.enqueue(7);
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test peek after enqueue 5,6,7", (int)arrayListQueue.peek() == 5 );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test contains 5", arrayListQueue.contains(5) == true );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test contains 9", arrayListQueue.contains(9) == false );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test remove 5", arrayListQueue.remove((Object)5) == true );
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test remove 9", arrayListQueue.remove((Object)9) == false );
        
        //test clear
        System.out.println("\tExecuting Test_ArrayrListQueue.testBehaviors - test clear");
        arrayListQueue.clear();
        assertTrue("\t\tTest_ArrayrListQueue.testBehaviors - test clear", arrayListQueue.getArrayList().size() == 0 );
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ArrayrListQueue suite");
      junit.textui.TestRunner.run(suite());
  }
	
    /* ATTRIBUTES	-----------------------------------------------	*/
    private ArrayListQueue arrayListQueue = null;
    private ArrayListQueue arrayListQueue2 = null;
}
