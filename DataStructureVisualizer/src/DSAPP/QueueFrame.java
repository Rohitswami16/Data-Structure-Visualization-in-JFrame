package DSAPP;

import javax.swing.*;
import java.awt.*;

public class QueueFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea outputBox;
	private Queue queue;

	public QueueFrame() {
		setType(Type.POPUP);
		setTitle("Queue Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton btnCreateQueue = new JButton("Create Queue");
		btnCreateQueue.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));

		buttonPanel.add(btnCreateQueue);
		buttonPanel.add(btnInsert);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnDisplay);

		contentPane.add(buttonPanel, BorderLayout.NORTH);

		outputBox = new JTextArea();
		outputBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		outputBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputBox);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		btnCreateQueue.addActionListener(e -> {
			String sizeStr = JOptionPane.showInputDialog(this, "Enter the size of the Queue:");
			try {
				int size = Integer.parseInt(sizeStr);
				if (size <= 0) {
					appendToOutput("Please enter a valid size greater than 0.");
					return;
				}
				queue = new Queue(size);
				appendToOutput("Queue of size " + size + " created.");
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnInsert.addActionListener(e -> {
			if (queue == null) {
				appendToOutput("Please create a Queue first.");
				return;
			}
			String valueStr = JOptionPane.showInputDialog(this, "Enter the value to insert:");
			try {
				int value = Integer.parseInt(valueStr);
				boolean inserted = queue.insert(value);
				if (inserted) {
					appendToOutput("Inserted: " + value);
				} else {
					appendToOutput("Queue is Full.");
				}
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnDelete.addActionListener(e -> {
			if (queue == null) {
				appendToOutput("Please create a Queue first.");
				return;
			}
			String deletedElement = queue.delete();
			appendToOutput(deletedElement);
		});

		btnDisplay.addActionListener(e -> {
			if (queue == null) {
				appendToOutput("Please create a Queue first.");
				return;
			}
			appendToOutput("Queue elements: " + queue.queueElementsToString());
		});
	}

	private void appendToOutput(String text) {
		outputBox.append(text + "\n");
		outputBox.setCaretPosition(outputBox.getDocument().getLength());
	}
}
