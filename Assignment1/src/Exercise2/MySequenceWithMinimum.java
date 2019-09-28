package Exercise2;

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
		return null;

	}

	public class Node {
		Integer value;
		Node next = null;
		Node prev = null;

		Node(int v) {
			value = v;
		}

	}
}
