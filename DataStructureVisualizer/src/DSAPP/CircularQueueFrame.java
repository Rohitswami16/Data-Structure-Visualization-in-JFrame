package DSAPP;

import javax.swing.*;
import java.awt.*;

public class CircularQueueFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea outputBox;
	private CircularQueue circularQueue;

	public CircularQueueFrame() {
		setType(Type.POPUP);
		setTitle("Circular Queue Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton btnCreateQueue = new JButton("Create Queue");
		btnCreateQueue.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnEnqueue = new JButton("Enqueue");
		btnEnqueue.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));

		buttonPanel.add(btnCreateQueue);
		buttonPanel.add(btnEnqueue);
		buttonPanel.add(btnDequeue);
		buttonPanel.add(btnDisplay);

		contentPane.add(buttonPanel, BorderLayout.NORTH);

		outputBox = new JTextArea();
		outputBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		outputBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputBox);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		btnCreateQueue.addActionListener(e -> {
			String sizeStr = JOptionPane.showInputDialog(this, "Enter the size of the Circular Queue:");
			try {
				int size = Integer.parseInt(sizeStr);
				circularQueue = new CircularQueue(size);
				appendToOutput("Circular Queue of size " + size + " created.");
			} catch (NumberFormatException ex) {
				appendToOutput("Invalid input for size.");
			}
		});

		btnEnqueue.addActionListener(e -> {
			if (circularQueue == null) {
				appendToOutput("Please create a Circular Queue first.");
				return;
			}
			String valueStr = JOptionPane.showInputDialog(this, "Enter the value to enqueue:");
			try {
				int value = Integer.parseInt(valueStr);
				if (circularQueue.enqueue(value)) {
					appendToOutput("Enqueued: " + value);
				} else {
					appendToOutput("Circular Queue is full. Cannot enqueue " + value);
				}
			} catch (NumberFormatException ex) {
				appendToOutput("Invalid input for value.");
			}
		});

		btnDequeue.addActionListener(e -> {
			if (circularQueue == null) {
				appendToOutput("Please create a Circular Queue first.");
				return;
			}
			int dequeuedValue = circularQueue.dequeue();
			if (dequeuedValue != -1) {
				appendToOutput("Dequeued element: " + dequeuedValue);
			} else {
				appendToOutput("Circular Queue is empty. No element to dequeue.");
			}
		});

		btnDisplay.addActionListener(e -> {
			if (circularQueue == null) {
				appendToOutput("Please create a Circular Queue first.");
				return;
			}
			appendToOutput("Circular Queue elements: " + circularQueue.displayQueue());
		});
	}

	private void appendToOutput(String text) {
		outputBox.append(text + "\n");
		outputBox.setCaretPosition(outputBox.getDocument().getLength());
	}
}
