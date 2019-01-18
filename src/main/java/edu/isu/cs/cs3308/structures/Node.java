package edu.isu.cs.cs3308.structures;
/**
 *
 * @author Jordan Lugo
 *
 * @param <E> The type that the data the node contains
 */
public class Node<E> {
	
	private Node nextNode; //This is a reference to the next node in the list
	private E data; //This is the element in which the node houses
	
	public Node(E element) {
		data = element;
	}
	
	public void setNext(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node getNext() {
		return nextNode;
	}
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
}
