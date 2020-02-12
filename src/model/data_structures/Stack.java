package model.data_structures;
import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> {


	private Node<T> topOfStack;

	private int stackSize;

	/**
	 * Constructor
	 */
	public Stack()
	{
		topOfStack = null;
		stackSize = 0;

	}

	/**
	 *
	 * @param input
	 */
	public void push(T nuevo) {
		if(topOfStack == null){
			topOfStack = new Node<>(nuevo, null, null);
		}
		else
		{
			Node<T> toPush = new Node<>(nuevo, topOfStack, null);
			topOfStack = toPush;
		}
		stackSize++;

	}

		/**
         *  ....
		 * @param m
		 */
	public T pop(T m)
	{
		if(isEmpty())
			throw new NoSuchElementException();
		T result = topOfStack.darValor();
		topOfStack = topOfStack.darSiguiente();
		stackSize--;

		return result;
	}

	/**
	 *
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty()
	{

		return topOfStack == null;
	}

	/**
	 * Returns the size of the stack.
	 * @return size of the stack.
	 */
	public int getSize()
	{

		return stackSize;
	}

	public T peek()
	{
		if(topOfStack != null)
			return topOfStack.darValor();
		else
			throw new  NoSuchElementException();
	}
	public Node<T> getTopOfStack() {
		return topOfStack;
	}

}































































































































