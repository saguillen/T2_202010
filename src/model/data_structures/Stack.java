package model.data_structures;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> {

	private T[] stackArr;

	private int topOfStack;

	private int stackSize;

	/**
	 * Constructor
	 */
	public Stack()
	{
		topOfStack = 0;
		stackSize = 0;

	}

	/**
	 *
	 * @param input
	 */
	public void push(T input) {
		if (getSize() == stackArr.length){
			stackArr[topOfStack] = input;
			topOfStack++;;
		}
		else
		{
			throw new NoSuchElementException();
		}
	}


		/**
         *  ....
         */
	public T pop()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		topOfStack--;
		T result = stackArr[topOfStack];
		stackArr[topOfStack] = null;

		return result;
	}

	/**
	 *
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return topOfStack == 0;
	}

	/**
	 * Gives the 1-based position of the item on the stack.
	 * @return The 1-based position from the top of the stack where the object is located; the return value -1 indicates that the object is not on the stack.
	 *
	 */
	public int search(T obj)
	{
		return 0;
	}

	/**
	 * Returns the size of the stack.
	 * @return size of the stack.
	 */
	public int getSize()
	{
		return topOfStack;
	}

	public T peek()
	{
		return null;
	}


}






























































































































