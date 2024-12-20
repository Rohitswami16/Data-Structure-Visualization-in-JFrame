package DSAPP;

public class CircularQueue {
	private int[] queue;
	private int size, front, rear;

	public CircularQueue(int size) {
		this.size = size;
		queue = new int[size];
		front = -1;
		rear = -1;
	}

	public boolean enqueue(int value) {
		if ((rear + 1) % size == front) {
			System.out.println("Queue is full");
			return false;
		}
		if (front == -1) {
			front = 0;
		}
		rear = (rear + 1) % size;
		queue[rear] = value;
		return true;
	}

	public int dequeue() {
		if (front == -1) {
			System.out.println("Queue is empty");
			return -1;
		}
		int dequeuedValue = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % size;
		}
		return dequeuedValue;
	}

	public String displayQueue() {
		if (front == -1) {
			return "Queue is empty.";
		}
		StringBuilder sb = new StringBuilder();
		int i = front;
		while (true) {
			sb.append(queue[i]).append(" ");
			if (i == rear)
				break;
			i = (i + 1) % size;
		}
		return sb.toString().trim();
	}
}
