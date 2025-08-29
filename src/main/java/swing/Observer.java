package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Observer {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Observer Window");
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dimension = new Dimension(600, 200);
		frame.setSize(dimension);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setLocationRelativeTo(null); // "null" value: centralize into screen computer.
		
		JButton button = new JButton("Click Here!");
		frame.add(button, BorderLayout.CENTER);
		
		button.addActionListener(e -> System.out.println("Event occurred!!!"));
		
		frame.setVisible(true);
	}
}
