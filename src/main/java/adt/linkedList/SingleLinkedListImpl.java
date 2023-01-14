package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	/* Verify if the head is NILL */
	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	/* Get the size of the list */
	@Override
	public int size() {
		SingleLinkedListNode<T> headAux = this.head;
		int totalSize = 0;
		while (!headAux.isNIL()) {
			headAux = headAux.getNext();
			totalSize++;
		}

		return totalSize;
	}

	/* Search an element into a list */
	@Override
	public T search(T element) {
		T elementFound = null;

		SingleLinkedListNode<T> headAux = this.head;
		while (!headAux.isNIL()) {
			if (headAux.getData().equals(element)) {
				elementFound = headAux.getData();
				break;
			}

			headAux = headAux.getNext();
		}

		return elementFound;
	}

	/* Insert an element into a list */
	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> headAux = this.head;
		if (this.head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, this.head);
			this.head = newHead;
		} else {
			while (!headAux.isNIL()) {
				headAux = headAux.getNext();
			}

			headAux.setData(element);
			headAux.setNext(new SingleLinkedListNode<T>());
		}
	}

	/* Remove an element from the list */
	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()) {
			if (aux.getData().equals(element)) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
				break;
			}

			aux = aux.getNext();
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		
		SingleLinkedListNode<T> aux = this.head;
		for (int i = 0; i < array.length; i++){
			array[i] = aux.getData();
			aux = aux.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
