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
			temp = new Node(value, tail, null);
			tail.next = temp;
			tail = temp;
		}
		size++;

	}

	@Override
	public Integer removeRight() {
		if (tail == null) {
			return null;
		}
		temp = tail.prev;
		tail = temp;
		tail.prev = temp.prev;

		System.out.println(head.value);
//		System.out.println(head.prev.value);
		size--;
		return this.temp.value;
	}

	@Override
	public void insertLeft(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value, null, null);
			head = temp;
			tail = temp;
		} else {
			temp = new Node(value, null, head);
			head.prev = temp;
			head = temp;

		}
		size++;
	}

	@Override
	public Integer removeLeft() {
		if (head == null) {
			return null;
		}
		temp = head.next;
		head = temp;
		head.next = temp.next;

		System.out.println(head.value);
//		System.out.println(head.prev.value);
		size--;
		return this.temp.value;

	}

	@Override
	public Integer findMinimum() {
		Node current = head;
		int min = Integer.MAX_VALUE;

		while (current != null) {
			if (current.value < min) {
				min = current.value;
			}

			current = current.next;
		}
		return min;
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

	private class Node {
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
