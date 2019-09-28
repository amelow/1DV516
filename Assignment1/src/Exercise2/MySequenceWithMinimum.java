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
			temp = new Node(value, tail, tail.next);
			tail.next = tail;
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
			temp = new Node(value, head.prev, head);
			head.prev = head;
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
		int count = 0;

		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public Object next() {
			if (hasNext() == false) {
				throw new IndexOutOfBoundsException();
			}
//			Node current = head.next;
			int temp = current.value;
			current = current.next;
			count++;
			return temp;
		}

	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		LinkedIterator iter = new LinkedIterator();
		build.append("{");
		while (iter.hasNext()) {
			build.append(iter.next() + ",");
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
