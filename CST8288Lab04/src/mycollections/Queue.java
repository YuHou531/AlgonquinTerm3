package mycollections;

import java.util.Iterator;

/**
 * Queue ADT
 * 
 * @author    Yu Hou
 * @version   Nov 20 2016
 *
 */
public interface Queue<E> {
	
	/**
	 * Inserts an element at the rear of the queue
	 * Adds the specified element to this queue
	 * 
	 * @param o new element to be inserted
	 * @throws NullObjectException  
	 */
	public boolean enqueue(E o) throws NullObjectException; 
	
	/**
	 * Retrieves, but does not remove, the head of this queue
	 * an error occurs if the queue is empty
	 * @throws EmptyQueueException 
	 */
	public E peek() throws EmptyQueueException;
	
	/**
	 * Retrieves and removes the head of this queue
	 * an error occurs if the queue is empty
	 * @throws EmptyQueueException 
	 */
	public E dequeue() throws EmptyQueueException;
	
	/**
	 * Returns the number of elements in this collection 
	 */
	public int size();
	
	/**
	 * Remove all elements from the queue
	 */
	public void clear();
	
	/**
	 * Returns an iterator over the elements in this queue
	 */
	public Iterator<E> iterator();
	
	/**
	 * Removes a single instance of the specified element
	 * from the collection if it is present (optional operation)
	 * 
	 * @param o Object to remove
	 */
	public boolean remove(Object o);
	
	/**
	 * Returns true if object "o" is present in the queue
	 * @param o Object to check contains
	 */
	public boolean contains(Object o);
}
