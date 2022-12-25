import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * Maybe later add mouse movement
 * */

@SuppressWarnings("serial")
public class Panel extends JPanel {

	Dot[] dots = new Dot[20];
	int width, height;

	public Panel(int width, int height, int dots) {
		super();
		this.width = width;
		this.height = height;
		this.dots = new Dot[dots];
	}

	@Override
	public void paintComponent(Graphics g) {

		// paint background
		paintBackground(g);

		// paint dots
		paintDots(g);

		// paint lines
		paintLines(g);
	}

	public void paintLines(Graphics g) {
		
		double distance = 0.0;
		
		for (int i = 0; i < dots.length; i++) {
			for (int j = 0; j < dots.length; j++) {
				
				//check if i == j
				if(i == j)
					continue;
				
				// distance
				distance = Math.sqrt((dots[j].PosY - dots[i].PosY) * (dots[j].PosY - dots[i].PosY) + (dots[j].PosX - dots[i].PosX) * (dots[j].PosX - dots[i].PosX));
				
				// color
//				g.setColor(new Color((int)(255 - distance/255), (int)(255 - distance/255), (int)(255 - distance/255)));

				g.setColor(Color.WHITE);
				for(int k = 0; k < (int)(distance/60); k++) {
					g.setColor(g.getColor().darker());
				}
				// draw Line
				g.drawLine(dots[i].PosX, dots[i].PosY, dots[j].PosX, dots[j].PosY);
			}
		}
	}

	public void createDots(int width, int height) {
		// create dots
		for (int i = 0; i < dots.length; i++) {
			dots[i] = new Dot((int) ((width-20) * Math.random()), (int) ((height-20) * Math.random()));
		}
	}

	public void paintBackground(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public void paintDots(Graphics g) {
		// dots
		g.setColor(Color.WHITE);

		// draw dots and move
		for (int i = 0; i < dots.length; i++) {
			g.fillOval(dots[i].PosX, dots[i].PosY, dots[i].size, dots[i].size);

			// add velocity
			dots[i].PosX += dots[i].velocityX;
			dots[i].PosY += dots[i].velocityY;

			// wall collision
			if (dots[i].PosX < 0 || dots[i].PosX > getWidth())
				dots[i].velocityX *= -1;
			
			else if( dots[i].PosY < 0 || dots[i].PosY > getHeight())
				dots[i].velocityY *= -1;
			
		}
	}

}
