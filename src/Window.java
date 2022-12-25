import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	Panel panel;
	int width = 1000;
	int height = 600;
	
	int dots = 20;
	
	public Window(int width, int height, int dots) {
//		setSize(new Dimension(850, 500));
		
		this.width = width;
		this.height = height;
		this.dots = dots;
		
		setPreferredSize(new Dimension(width, height));
		setTitle("Background");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new Panel(getWidth(), getHeight(), dots);
		panel.createDots(getWidth(), getHeight());
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		setSize(width, height);
		setVisible(true);
	}
}

