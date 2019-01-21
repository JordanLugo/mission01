package edu.isu.cs.cs3308.structures;
/**
 *
 * @author Jordan Lugo
 *
 * @param <E> The type that the data the node contains
 */
public class Node<E> {
	
	private Node<E> nextNode; //This is a reference to the next node in the list
	private E data; //This is the element in which the node houses
	
	/**
	 * Creates a node with the given element
	 * @param element of the node. AKA it's contents
	 */
	public Node(E element) {
		data = element;
	}
	/**
	 * @param nextNode the next node in the list.
	 */
	public void setNext(Node<E> nextNode) {
		this.nextNode = nextNode;
	}
	/**
	 * @return the reference to the next node
	 */
	public Node<E> getNext() {
		return nextNode;
	}
	
	/**
	 * @return the data of this instance of Node
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * Sets this instance of Node's data. 
	 * @param data
	 */
	public void setData(E data) {
		this.data = data;
	}
}
