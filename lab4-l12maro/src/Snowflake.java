/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2019
 * Assignment:	lab 4, 1
 * Author: 		Lorena Martin Rodriguez
 * Description: A program to draw snowflakes
 * Honor Code:  I pledge that this program represents my own work.
 *              I received help from:
 *				the Github issues section
 *              in designing and debugging my program.
 */

import java.applet.Applet;
import java.awt.*;
import java.lang.Math;

public class Snowflake extends Applet {
	int minLen;
	/**
	 * Draw a snowflake like star at coordinate x, y on Canvas canvas
	 * The beams of the star are beamLen pixels long
	 */
	private void drawStar(Graphics canvas, int x, int y, int beamLen) {
		//create a stop case
		//the snowflake should have three layers of beams
		if (beamLen < minLen) return;
		//draw the star
		for (int i = 0; i < 6; i++) {
			int endX = x + (int) (beamLen * Math.cos(((2 * Math.PI) / 6) * i));
			int endY = y - (int) (beamLen * Math.sin(((2 * Math.PI) / 6) * i));
			canvas.drawLine(x, y, endX, endY);
			//repeat for all layers
			drawStar(canvas, endX, endY, beamLen/3);
		}

	}

	/**
	 * Paint method of the applet. Gets called whenever the applet needs a redraw
	 * @param gr - The canvas to draw the applets content on
	 */
	public void paint(Graphics gr) {
		int width = getSize().width;
		int height = getSize().height;
		int min; //This variable is not necessary, but it might be useful

		// Set background and pen color
		setBackground(Color.white);
		gr.setColor(Color.blue);

		// Calculate the maximal length in the window
		int maxLen;
		if (width <= height) {
			//the length must be smaller than the distance from the center to the border
			//since we need to leave space for the smaller beams
			maxLen = width/3;
		}
		else {
			maxLen = height/3;
		}
		// Calculate the length of the smallest layer
		minLen = maxLen/9;

		// Draw a star
		drawStar(gr, width/2, height/2, maxLen);
	}
}
