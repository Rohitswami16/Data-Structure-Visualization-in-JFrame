package DSAPP;

import javax.swing.*;
import java.awt.*;

public class StackFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea outputBox;
	private Stack stack;

	public StackFrame() {
		setType(Type.POPUP);
		setForeground(UIManager.getColor("CheckBox.focus"));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Stack Operations");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton btnCreateStack = new JButton("Create Stack");
		btnCreateStack.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnPush = new JButton("Push");
		btnPush.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnPop = new JButton("Pop");
		btnPop.setFont(new Font("Tahoma", Font.BOLD, 16));
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));

		buttonPanel.add(btnCreateStack);
		buttonPanel.add(btnPush);
		buttonPanel.add(btnPop);
		buttonPanel.add(btnDisplay);

		contentPane.add(buttonPanel, BorderLayout.NORTH);

		outputBox = new JTextArea();
		outputBox.setFont(new Font("Monospaced", Font.BOLD, 18));
		outputBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputBox);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		btnCreateStack.addActionListener(e -> {
			String sizeStr = JOptionPane.showInputDialog(this, "Enter the size of the stack:");
			try {
				int size = Integer.parseInt(sizeStr);
				stack = new Stack(size);
				appendToOutput("Stack of size " + size + " created.");
			} catch (NumberFormatException ex) {
				appendToOutput("Invalid input for size.");
			}
		});

		btnPush.addActionListener(e -> {
			if (stack == null) {
				appendToOutput("Please create a stack first.");
				return;
			}
			String valueStr = JOptionPane.showInputDialog(this, "Enter the value to push:");
			try {
				int value = Integer.parseInt(valueStr);
				boolean isPushed = stack.push(value);

				if (isPushed) {
					appendToOutput("Pushed " + value + " onto the stack.");
				} else {
					appendToOutput("Stack is full. Unable to push " + value
							+ ". Please pop some elements before pushing more.");
				}
			} catch (NumberFormatException ex) {
				appendToOutput("Invalid input for value.");
			}
		});

		btnPop.addActionListener(e -> {
			if (stack == null) {
				appendToOutput("Please create a stack first.");
				return;
			}
			int poppedValue = stack.pop();

			if (poppedValue != -1) {
				appendToOutput("Popped element: " + poppedValue);
			} else {
				appendToOutput("Stack is empty. No element to pop.");
			}
		});

		btnDisplay.addActionListener(e -> {
			if (stack == null) {
				appendToOutput("Please create a stack first.");
				return;
			}
			String stackContent = stack.display();
			appendToOutput("Stack elements: " + stackContent);
		});
	}

	private void appendToOutput(String text) {
		outputBox.append(text + "\n");
		outputBox.setCaretPosition(outputBox.getDocument().getLength());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			StackFrame frame = new StackFrame();
			frame.setVisible(true);
		});
	}
}
