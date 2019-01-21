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
	public E first() {
		return head == null ? null : head.getData();
	}

	@Override
	public E last() {
		return tail == null ? null : tail.getData();
	}

	@Override
	public void addLast(E element) {
		if (element == null)
			return;

		Node<E> newNode = new Node<>(element);

		if (size > 0) {
			getNode(size - 1).setNext(newNode);
		}

		newNode.setNext(null);
		tail = newNode;

		if (head == null) {
			head = newNode;
		}

		size++;

	}

	@Override
	public void addFirst(E element) {
		if (element == null)
			return;

		Node<E> newNode = new Node<>(element);

		if (head == null) {
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
		if(head == null) return null;
		
		Node<E> currentHead = head;
		head = currentHead.getNext();
		currentHead.setNext(null);
		size--;
		
		return currentHead == null ? null : currentHead.getData();
	}

	@Override
	public E removeLast() {
		if(size == 0) return null;
		
		Node<E> currentTail = tail;
		Node<E> newTail = getNode(size - 1);
		newTail.setNext(null);
		tail = newTail;
		size--;

		return (currentTail == null) ? null : currentTail.getData();
	}

	@Override
	public void insert(E element, int index) {
		if (index < 0)
			return;
		if (element == null) 
			return;
		if(index > size) {
			addLast(element);
			return;
		}
		
		Node<E> newNode = new Node<E>(element);

		getNode(index - 1).setNext(newNode);
		newNode.setNext(getNode(index + 1));

		size++;
	}
	
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) return null;
		if(size == 0) return null;
		
		Node<E> current = getNode(index);

		Node<E> next = current.getNext();
		Node<E> previous = getNode(index-1);
		
		previous.setNext(next);
		current.setNext(null);

		size--;
		return current.getData();
	}

	
	@Override
	public E get(int index) {
		if(index < 0 || index > size)
			return null;
		return getNode(index) == null ? null : getNode(index).getData();
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
		String returnString = "";
		for (int i = 0; i < size; i++) {
			returnString += (i == size-1) ? getNode(i).getData() : getNode(i).getData() + System.lineSeparator();
		}
		System.out.println(returnString.trim());
	}

	/**
	 * Gets a node at a specific index
	 * 
	 * @param index of the node that you want that is base 1
	 * @return the node at the indicated index.
	 */
	private Node<E> getNode(int index) {
		Node<E> returnNode = head;

		if (returnNode != null) {
			for (int i = 0; i < index; i++)
				returnNode = returnNode.getNext();
		}

		return returnNode;
	}
}
