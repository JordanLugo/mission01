package edu.isu.cs.cs3308.structures;

import edu.isu.cs.cs3308.structures.Node;

/**
 * 
 * @author Jordan Lugo
 *
 * @param <E> The type of that you want to collect
 */
public class SinglyLinkedList<E> implements List<E> {
	
	protected Node<E> head;
	protected Node<E> tail;
	protected int size = 0;
	
	@Override
	public E first() { return head.getData(); }
	
	@Override
	public E last() { return tail.getData();}

	@Override
	public void addLast(E element) {
		Node<E> newNode = new Node<>(element);
		
		if(size > 0) {
			getNode(size-1).setNext(newNode);
		} 
		newNode.setNext(null);
		tail = newNode;
		size++;
	}

	@Override
	public void addFirst(E element) {
		Node<E> newNode  = new Node<>(element);
		
		if(head == null) {
			newNode.setNext(null);
		} else {
			Node<E> currentHead = head;
			newNode.setNext(currentHead);
		}
		
		head = newNode;
		size++;
	}

	@Override
	public E removeFirst() {
		Node<E> currentHead = head;
		head = currentHead.getNext();
		currentHead.setNext(null);
		size--;
		return null;
	}

	@Override
	public E removeLast() {
		Node<E> currentTail = tail;
		
		Node<E> newTail = getNode(size-1);
		newTail.setNext(null);
		tail = newTail;
		size--;
			
		return (currentTail == null) ? null : currentTail.getData();
	}

	@Override
	public void insert(E element, int index) {
		if(index < 0 || index > size)
			return;
		
		Node<E> newNode = new Node<E>(element);
		
		getNode(index - 1).setNext(newNode);
		newNode.setNext(getNode(index + 1));
		
		size++;
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size)
			return null;
		
		Node<E> current = getNode(index);
		
		Node<E> toRemove = current.getNext();
		current.setNext(toRemove.getNext());
		toRemove.setNext(null);
		
		size--;
		return toRemove.getData();
	}

	@Override
	public E get(int index) {
		return getNode(index).getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void printList() {
		
		
	}
	
	/**
	 * Gets a node at a specific index
	 * @param index of the node that you want that is base 1
	 * @return the node at the indicated index.
	 */
	private Node<E> getNode(int index) {
		Node<E> returnNode = head;
		
		if(returnNode != null) {
			for(int i = 0; i < index; i++)
				returnNode = returnNode.getNext();
		}
		
		return returnNode;
	}
}
