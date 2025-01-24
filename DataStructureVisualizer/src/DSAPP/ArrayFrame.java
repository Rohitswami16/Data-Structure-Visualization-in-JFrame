package DSAPP;
import javax.swing.*;
import java.awt.*;

public class ArrayFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea outputBox;
	private Array array;

	public ArrayFrame() {
		setType(Type.POPUP);
		setTitle("Array Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 549);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnSort = new JButton("Sort");
		btnSort.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnSetSize = new JButton("Set Array Size");
		btnSetSize.setFont(new Font("Tahoma", Font.BOLD, 16));

		buttonPanel.add(btnSetSize);
		buttonPanel.add(btnInsert);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnDisplay);
		buttonPanel.add(btnSearch);
		buttonPanel.add(btnSort);

		contentPane.add(buttonPanel, BorderLayout.NORTH);

		outputBox = new JTextArea();
		outputBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		outputBox.setTabSize(14);
		outputBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputBox);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		array = new Array(10, outputBox);

		btnSetSize.addActionListener(e -> {
			String sizeStr = JOptionPane.showInputDialog(this, "Enter the size of the array:");
			try {
				int size = Integer.parseInt(sizeStr);
				if (size > 0) {
					array = new Array(size, outputBox);
					appendToOutput("Array size set to " + size);
				} else {
					appendToOutput("Please enter a positive number for size.");
				}
			} catch (NumberFormatException ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnInsert.addActionListener(e -> {
			String indexStr = JOptionPane.showInputDialog(this, "Enter the index:");
			try {
				int index = Integer.parseInt(indexStr);

				if (index >= 0 && index < array.getArraySize()) {
					String valueStr = JOptionPane.showInputDialog(this, "Enter the value:");
					int value = Integer.parseInt(valueStr);
					array.insert(index, value);
					appendToOutput("Inserted " + value + " at index " + index);
				} else {
					appendToOutput("Please give a valid array index between 0 and " + (array.getArraySize() - 1));
				}
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnDelete.addActionListener(e -> {
			String indexStr = JOptionPane.showInputDialog(this, "Enter the index to delete:");
			try {
				int index = Integer.parseInt(indexStr);
				Integer deletedElement = array.delete(index);

				if (deletedElement != null) {
					appendToOutput("Deleted element: " + deletedElement + " at index " + index);
				} else {
					appendToOutput("Invalid index. No element deleted.");
				}
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnDisplay.addActionListener(e -> {
			String arrayElements = array.display();
			appendToOutput("Array elements: " + arrayElements);
		});

		btnSearch.addActionListener(e -> {
			String keyStr = JOptionPane.showInputDialog(this, "Enter the key to search:");
			try {
				int key = Integer.parseInt(keyStr);
				int index = array.BinarySearch(key);

				if (index != -1) {
					appendToOutput("Key " + key + " found at index: " + index);
				} else {
					appendToOutput("Key " + key + " not found in the array.");
				}
			} catch (Exception ex) {
				appendToOutput("Invalid input: " + ex.getMessage());
			}
		});

		btnSort.addActionListener(e -> {
			String sortedArray = array.Sort();
			appendToOutput("Sorted Array: " + sortedArray);
		});

	}

	private void appendToOutput(String text) {
		outputBox.append(text + "\n");
		outputBox.setCaretPosition(outputBox.getDocument().getLength());
	}
}
