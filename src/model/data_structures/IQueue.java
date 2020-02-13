package model.data_structures;

public interface IQueue<T extends Comparable<T>> {

	Node<T> darPrimero();
	
	Node<T> darUltimo();
	
	boolean isEmpty();
	
	T enqueue(T pNuevo);
	
	void dequeue();
	
	int darTama�o();
	
	Node<T> darActual(int pPosicion);
	
}
