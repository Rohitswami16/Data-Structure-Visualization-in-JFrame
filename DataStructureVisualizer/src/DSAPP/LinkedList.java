package DSAPP;

public class LinkedList {

	class Node {
		Node pl;
		int data;
		Node nl;
	}

	Node first = null;

	public void insertFirst(int element) {
		Node nn = new Node();
		nn.data = element;
		nn.pl = null;
		nn.nl = first;
		if (first != null) {
			first.pl = nn;
		}
		first = nn;
	}

	public void insertLast(int element) {
		Node nn = new Node();
		nn.data = element;
		nn.nl = null;

		if (first == null) {
			first = nn;
			nn.pl = null;
		} else {
			Node temp = first;
			while (temp.nl != null) {
				temp = temp.nl;
			}
			temp.nl = nn;
			nn.pl = temp;
		}
	}

	public int deleteFirst() {
		if (first == null) {
			return -1;
		} else {
			int deletedData = first.data;
			first = first.nl;

			if (first != null) {
				first.pl = null;
			}

			return deletedData;
		}
	}

	public int deleteLast() {
		if (first == null) {
			return -1;
		} else if (first.nl == null) {
			int deletedData = first.data;
			first = null;
			return deletedData;
		} else {
			Node temp = first;
			while (temp.nl != null) {
				temp = temp.nl;
			}
			int deletedData = temp.data;
			temp.pl.nl = null;
			return deletedData;
		}
	}

	public String displayElements() {
		if (first == null) {
			return "LinkedList is empty.";
		}

		StringBuilder elements = new StringBuilder();
		Node temp = first;

		while (temp != null) {
			elements.append(temp.data).append(" ");
			temp = temp.nl;
		}
		return elements.toString().trim();
	}
}
