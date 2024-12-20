package DSAPP;

import javax.swing.*;
import java.awt.*;

public class LinkedListFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea outputBox;
	private LinkedList linkedList;

	public LinkedListFrame() {
		setType(Type.POPUP);
		setTitle("LinkedList Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton btnCreateList = new JButton("Create LinkedList");
		btnCreateList.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnInsertFirst = new JButton("Insert First");
		btnInsertFirst.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnInsertLast = new JButton("Insert Last");
		btnInsertLast.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDeleteFirst = new JButton("Delete First");
		btnDeleteFirst.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDeleteLast = new JButton("Delete Last");
		btnDeleteLast.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));

		buttonPanel.add(btnCreateList);
		buttonPanel.add(btnInsertFirst);
		buttonPanel.add(btnInsertLast);
		buttonPanel.add(btnDeleteFirst);
		buttonPanel.add(btnDeleteLast);
		buttonPanel.add(btnDisplay);

		contentPane.add(buttonPanel, BorderLayout.NORTH);

		outputBox = new JTextArea();
		outputBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		outputBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputBox);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		btnCreateList.addActionListener(e -> {
			linkedList = new LinkedList();
			appendToOutput("LinkedList created.");
		});

		btnInsertFirst.addActionListener(e -> {
			if (linkedList == null) {
				appendToOutput("Please create a LinkedList first.");
				return;
			}
			String valueStr = JOptionPane.showInputDialog(this, "Enter the value to insert at the beginning:");
			try {
				int value = Integer.parseInt(valueStr);
				linkedList.insertFirst(value);
				appendToOutput("Inserted " + value + " at the beginning.");
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnInsertLast.addActionListener(e -> {
			if (linkedList == null) {
				appendToOutput("Please create a LinkedList first.");
				return;
			}
			String valueStr = JOptionPane.showInputDialog(this, "Enter the value to insert at the end:");
			try {
				int value = Integer.parseInt(valueStr);
				linkedList.insertLast(value);
				appendToOutput("Inserted " + value + " at the end.");
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnDeleteFirst.addActionListener(e -> {
			if (linkedList == null) {
				appendToOutput("Please create a LinkedList first.");
				return;
			}
			int deletedValue = linkedList.deleteFirst();
			if (deletedValue != -1) {
				appendToOutput("Deleted the first element: " + deletedValue);
			} else {
				appendToOutput("Delete operation not possible: LinkedList is empty.");
			}
		});

		btnDeleteLast.addActionListener(e -> {
			if (linkedList == null) {
				appendToOutput("Please create a LinkedList first.");
				return;
			}
			int deletedValue = linkedList.deleteLast();
			if (deletedValue != -1) {
				appendToOutput("Deleted the last element: " + deletedValue);
			} else {
				appendToOutput("Delete operation not possible: LinkedList is empty.");
			}
		});

		btnDisplay.addActionListener(e -> {
			if (linkedList == null) {
				appendToOutput("Please create a LinkedList first.");
				return;
			}
			String linkedListElements = linkedList.displayElements();
			appendToOutput("LinkedList elements: " + linkedListElements);
		});
	}

	private void appendToOutput(String text) {
		outputBox.append(text + "\n");
		outputBox.setCaretPosition(outputBox.getDocument().getLength());
	}
}
