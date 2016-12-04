package mycollections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList implements Queue ADT
 * 
 * @author    Yu Hou
 * @version   Nov 20 2016
 *
 */
public class ArrayListQueue<E> extends ArrayList implements Queue<E>, Iterator<E> {
	
	/**
	 * ArrayList instance used to hold queue structure 
	 */
	private ArrayList<E> arraylist; 
	
	/**
	 * ArrayList instance for current queue
	 */
	private ArrayList<E> currentQueueList; 
	
	/**
	 * iterator instance over the elements in this queue
	 */
	private Iterator<E> iterator;
	
	/**
	 * index in the arraylist where to store the first element of the queue
	 */
	private int first;
	
	/**
	 * index in the arraylist where to store the next available element of the queue
	 */
	private int next;

	/**
	 * ArrayListQueue constructor
	 */
	public ArrayListQueue() {
		arraylist = new ArrayList<E>();
		first = 0;
		next = arraylist.size();
	}
	
	/**
	 * Inserts an element at the rear of the queue
	 * Adds the specified element to this queue
	 * 
	 * @param o new element to be inserted
	 */
	@Override
	public boolean enqueue(E o) throws NullObjectException {
		if(arraylist == null) {
			return false;
		}
		if( o == null ) {
			throw new NullObjectException("cannot add null to the queue");
		}
		arraylist.add(next, o);  //add element to the arraylist index - next
		return true;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue
	 * an error occurs if the queue is empty
	 */
	@Override
	public E peek() throws EmptyQueueException {
		if(arraylist == null) {
			throw new java.util.NoSuchElementException("arraylist is empty");
		}
		if(first == next) {
			throw new EmptyQueueException("queue is empty");
		}
		return arraylist.get(first);
	}

	/**
	 * Retrieves and removes the head of this queue
	 * an error occurs if the queue is empty
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		if(arraylist == null) {
			throw new java.util.NoSuchElementException("arraylist is empty");
		}
		if(first == next) {
			throw new EmptyQueueException("queue is empty");
		}
		E firstElement = arraylist.get(first);
		first = first++;
		return firstElement;
	}

	/**
	 * Returns the number of elements in this collection (queue)
	 */
	@Override
	public int size() {
		return next - first;
	}

	/**
	 * Remove all elements from the queue
	 */
	@Override
	public void clear() {
		arraylist = new ArrayList<E>();
		first = 0;
		next = arraylist.size();
	}

	/**
	 * Returns an iterator over the elements in this queue
	 */
	@Override
	public Iterator<E> iterator() {
		currentQueueList = new ArrayList<E>();
		for(int i = first; i<next; i++)
		{
			currentQueueList.add(arraylist.get(i));
		}
		iterator = currentQueueList.iterator();
		return iterator;
	}

	/**
	 * Removes a single instance of the specified element
	 * from the collection if it is present (optional operation)
	 * 
	 * @param o Object to remove
	 */
	@Override
	public boolean remove(Object o) {
        if(contains(o)) {
        	arraylist.remove(o);
        	return true;
        }
		return false;
	}

	/**
	 * Returns true if object "o" is present in the queue
	 * @param o Object to check contains
	 */
	@Override
	public boolean contains(Object o) {
		while(hasNext()) {
			if(next().equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check whether queue has next element
	 */
	@Override
	public boolean hasNext() {
		return iterator().hasNext();
	}

	/**
	 * returns next element in the queue
	 */
	@Override
	public E next() {
		return iterator().next();
	}

}
