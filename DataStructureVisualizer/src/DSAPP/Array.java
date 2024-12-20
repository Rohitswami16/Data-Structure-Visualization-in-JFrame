package DSAPP;

import javax.swing.JTextArea;

public class Array {

	private int[] arr;

	public Array(int size, JTextArea outputBox) {
		if (size >= 0) {
			arr = new int[size];
			System.out.println("Array of size " + arr.length + " created \n");
		} else {
			System.out.println("Array of size should not be negative \n");
		}
	}

	public boolean insert(int index, int element) {
		if (0 <= index && arr.length > index) {
			arr[index] = element;
			System.out.println("Element " + element + " inserted at index " + index + "\n");
			return true;
		} else {
			System.out.println("Array index out of range.\n");
			return false;
		}
	}

	public int getArraySize() {
		return arr.length;
	}

	public Integer delete(int index) {
		if (0 <= index && arr.length > index) {
			int deletedElement = arr[index];
			arr[index] = 0;
			return deletedElement;
		} else {
			System.out.println("Array index out of range.\n");
			return null;
		}
	}

	public String display() {
		StringBuilder output = new StringBuilder();
		output.append("[");
		for (int a : arr) {
			output.append(a).append(", ");
		}
		if (arr.length > 0) {
			output.delete(output.length() - 2, output.length());
		}
		output.append("]");
		return output.toString();
	}

	public int BinarySearch(int key) {
		Sort();
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == key) {
				return mid;
			}

			if (arr[mid] < key) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	public String Sort() {
		int min;
		int pos;
		for (int i = 0; i <= arr.length - 2; i++) {
			min = arr[i];
			pos = i;
			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[j] < min) {
					min = arr[j];
					pos = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}

		StringBuilder output = new StringBuilder();
		output.append("[");
		for (int a : arr) {
			output.append(a).append(", ");
		}
		if (arr.length > 0) {
			output.delete(output.length() - 2, output.length());
		}
		output.append("]");

		return output.toString();
	}

}
