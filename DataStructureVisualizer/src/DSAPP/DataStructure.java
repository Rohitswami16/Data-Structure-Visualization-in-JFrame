package DSAPP;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;

public class DataStructure extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataStructure frame = new DataStructure();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DataStructure() {
		setBackground(new Color(240, 240, 240));
		setType(Type.POPUP);
		setTitle("DATA STRUCTURE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblHeading = new JLabel("CHOOSE DATA STRUCTURE");
		lblHeading.setBackground(new Color(240, 240, 240));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeading.setBounds(139, 27, 252, 30);
		contentPane.add(lblHeading);

		JButton btnArray = new JButton("ARRAY");
		btnArray.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnArray.setBounds(164, 80, 184, 40);
		contentPane.add(btnArray);

		JButton btnStack = new JButton("STACK");
		btnStack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStack.setBounds(164, 130, 184, 40);
		contentPane.add(btnStack);

		JButton btnQueue = new JButton("QUEUE");
		btnQueue.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQueue.setBounds(164, 180, 184, 40);
		contentPane.add(btnQueue);

		JButton btnCircularQueue = new JButton("CIRCULAR QUEUE");
		btnCircularQueue.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCircularQueue.setBounds(164, 230, 184, 40);
		contentPane.add(btnCircularQueue);

		JButton btnLinkedList = new JButton("LINKED LIST");
		btnLinkedList.setToolTipText("");
		btnLinkedList.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLinkedList.setBounds(164, 280, 184, 40);
		contentPane.add(btnLinkedList);
		btnArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ArrayFrame().setVisible(true);
			}
		});

		btnStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StackFrame().setVisible(true);
			}
		});

		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueueFrame().setVisible(true);
			}
		});

		btnCircularQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CircularQueueFrame().setVisible(true);
			}
		});

		btnLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LinkedListFrame().setVisible(true);
			}
		});
	}
}
