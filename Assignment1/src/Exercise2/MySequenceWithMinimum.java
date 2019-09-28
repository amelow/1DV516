package Exercise2;

public class MySequenceWithMinimum implements A1SequenceWithMinimum {
	private Node head = null;
	private Node tail = null;
	private int next;
	private int prev;

	public MySequenceWithMinimum() {

	}

	@Override
	public void insertRight(Integer value) {
		if (head == null) {
			head = new Node(value);
			  tail = null;
		} else if(tail== null){
			  tail = new Node(value);
			System.out.println("hej"+ value);

		}

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

	public class Node {
		Integer value;
		Node left = null;
		Node right = null;

		Node(int v) {
			value = v;
		}

	}
}
