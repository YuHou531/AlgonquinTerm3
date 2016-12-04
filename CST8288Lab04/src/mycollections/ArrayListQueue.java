package mycollections;

import java.util.ArrayList;
import java.util.Iterator;


//ref
//http://eddmann.com/posts/implementing-a-queue-in-java-using-arrays-and-linked-lists/
public class ArrayListQueue<E> extends ArrayList implements Queue<E>  {
	
	private ArrayList<E> arraylist;

	/**
	 * Default constructor
	 */
	public ArrayListQueue() {
		arraylist = new ArrayList<E>();
	}
	
	/**
	 * Inserts an element at the rear of the queue
	 * Adds the specified element to this queue
	 * 
	 * @param o new element to be inserted
	 */
	@Override
	public boolean enqueue(E o) {
		if(arraylist == null) {
			return false;
		}
		arraylist.add(o);
		return true;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue
	 * an error occurs if the queue is empty
	 */
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieves and removes the head of this queue
	 * an error occurs if the queue is empty
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the number of elements in this collection 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Remove all elements from the queue
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Returns an iterator over the elements in this queue
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes a single instance of the specified element
	 * from the collection if it is present (optional operation)
	 * 
	 * @param o Object to remove
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns true if object "o" is present in the queue
	 * @param o Object to check contains
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
