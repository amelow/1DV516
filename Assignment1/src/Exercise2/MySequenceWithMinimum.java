package Exercise2;

import java.util.Iterator;

public class MySequenceWithMinimum implements A1SequenceWithMinimum {
	private Node head = null;
	private Node tail = null;
	private Node temp = null;

	public MySequenceWithMinimum() {

	}

	@Override
	public void insertRight(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value);
			head = temp;
			tail = temp;
		} else {
			tail.next = new Node(value);
			tail = tail.next;
		}
		 System.out.print(value + ",");

	}

	@Override
	public Integer removeRight() {

		return null;
	}

	@Override
	public void insertLeft(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value);
			head = temp;
			tail = temp;
		} else {
			head.next = head;
			head = new Node(value);
			
		}
	}

	@Override
	public Integer removeLeft() {

		return null;
	}

	@Override
	public Integer findMinimum() {

		return null;
	}

	public String toString() {
		StringBuilder strB = new StringBuilder();
		strB.append("{");
		return strB.toString();
		

	}

	/*
	 * if (head == null) { return null;
	 * 
	 * } StringBuilder strB = new StringBuilder(); for (int i = 0; i <
	 * strB.length(); i++) { strB.append(strB.toString()); strB.append("\n"); //
	 * strB.append("{");
	 * 
	 * } return strB.toString();
	 * 
	 * }
	 */
	public class Node {
		Integer value;
		Node next = null;
		Node prev = null;

		Node(int v) {
			value = v;
		}

	}
}
