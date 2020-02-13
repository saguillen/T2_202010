package model.data_structures;

public interface IStack<T extends Comparable<T>> {

	
	void push(T nuevo);
	
	T pop(T m);
	
	boolean isEmpty();
	
	int getSize();
	
	T peek();
	
	Node<T> getTopOfStack();
	
	Node<T> darActual(int pPosicion);
	
	
}
