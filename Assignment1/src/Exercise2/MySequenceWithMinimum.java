package Exercise2;

import java.util.Iterator;

public class MySequenceWithMinimum implements A1SequenceWithMinimum {
	private Node head = null;
	private Node tail = null;
	private Node temp = null;
	private int size = 0;

	public MySequenceWithMinimum() {

	}

	@Override
	public void insertRight(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value, null, null);
			head = temp;
			tail = temp;
		} else {
			temp = new Node(value, null, tail.prev);
			tail.prev = tail;
			tail = temp;
		}
		size++;

	}

	@Override
	public Integer removeRight() {

		return null;
	}

	@Override
	public void insertLeft(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value, null, null);
			head = temp;
			tail = temp;
		} else {
			temp = new Node(value, head, null);
			head.next = head;
			head = temp;

		}
		size++;
	}

	@Override
	public Integer removeLeft() {

		return null;
	}

	@Override
	public Integer findMinimum() {

		return null;
	}

	private class LinkedIterator implements Iterator<Object> {
		private Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			if (hasNext() == false) {
				throw new IndexOutOfBoundsException();
			}
//			Node currentNode = current;
			Integer temp = current.value;
			current = current.next;
//			currentNode = current;
			System.out.println("Current: " + temp);
			return temp;
		}

	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		LinkedIterator iter = new LinkedIterator();
		build.append("{");
		while (iter.hasNext()) {
			build.append(iter.next() + ",");
			System.out.println(build.toString());
		}
		build.deleteCharAt(build.length() - 1);
		build.append("}");
		return build.toString();

	}


	public class Node {
		Integer value;
		Node next = null;
		Node prev = null;

		Node(int v, Node previous, Node next) {
			value = v;
			this.next = next;
			this.prev = previous;
		}

	}
}
