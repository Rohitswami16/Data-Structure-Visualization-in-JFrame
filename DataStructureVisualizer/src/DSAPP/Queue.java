package DSAPP;

public class Queue {
	private int[] q;
	private int size;
	private int f = -1;
	private int r = -1;

	public Queue(int size) {
		if (size > 0) {
			this.size = size;
			q = new int[size];
			System.out.println("Queue of size " + size + " is created.");
		} else {
			throw new IllegalArgumentException("Please provide a valid size greater than 0.");
		}
	}

	public boolean insert(int element) {
		if (r == size - 1) {
			System.out.println("Queue is Full");
			return false;
		} else {
			r++;
			q[r] = element;
			System.out.println("Element " + element + " is inserted.");
			return true;
		}
	}

	public String delete() {
		if ((f == -1 && r == -1) || (f == r)) {
			return "Queue is Empty";
		} else {
			f++;
			int deletedElement = q[f];
			q[f] = 0;
			return "Element deleted is " + deletedElement;
		}
	}

	public String queueElementsToString() {
		if ((f == -1 && r == -1) || (f == r)) {
			return "Queue is Empty";
		} else {
			StringBuilder elements = new StringBuilder();
			for (int i = f + 1; i <= r; i++) {
				elements.append(q[i]).append(" ");
			}
			return elements.toString().trim();
		}
	}

	public int[] getQueueArray() {
		return q.clone();
	}
}
