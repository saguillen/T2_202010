package model.data_structures;

import jdk.nashorn.internal.ir.visitor.NodeOperatorVisitor;

public class Queue<T extends Comparable<T>> {

	private Node<T> primero;

	private Node<T> ultimo;

	private int size;

	public Queue() {


	}

	
	public Node<T> darPrimero()
	{
		return primero;
	}

	public Node<T> darUltimo()
	{
		Node<T> actual = primero;

		while(actual!= null && actual.darSiguiente()!=null) 
		{
			actual = actual.darSiguiente(); 
		}

		return actual;	
	}
	
	public boolean isEmpty()
	{

		return primero==null?true:false;
	}

	public T enqueue(T pNuevo)
	{
		Node<T> nenqueue = new Node<T>(pNuevo, null, null);
		
		if(isEmpty()){
			
			primero= nenqueue;
			ultimo = primero;
		}else{
			Node<T> nuevoNodo = nenqueue;
			ultimo.cambiarSiguiente(nuevoNodo);
			nuevoNodo.cambiarAnterior(ultimo);
			ultimo = nuevoNodo;
		}
		size++;
		
		return nenqueue.darValor();
		
	}
	
	public T dequeue(){
		
		if(!isEmpty())
		{
			return null;
		}
		T valor = primero.darValor();
		 primero = primero.darSiguiente();
		 size--;
		 
		 return valor;
	}

	public int darTamaño()
	{
		return size;
	}
}
