package DSAPP;

public class Stack {
	private int size;
	private int top = -1;
	private int[] s;

	public Stack(int size) {
		if (size > 0) {
			this.size = size;
			s = new int[size];
			System.out.println("Stack of size " + size + " is created");
		} else {
			System.out.println("Give a valid size between 0 to " + (size - 1));
		}
	}

	public boolean push(int element) {
		if (top < size - 1) {
			top++;
			s[top] = element;
			return true;
		} else {
			return false;
		}
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		} else {
			int poppedValue = s[top];
			top--;
			return poppedValue;
		}
	}

	public String display() {
		if (top == -1) {
			return "Stack is Empty";
		} else {
			StringBuilder stackContent = new StringBuilder();
			for (int i = top; i >= 0; i--) {
				stackContent.append(s[i]).append(" ");
			}
			return stackContent.toString().trim();
		}
	}
}
