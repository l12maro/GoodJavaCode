/**
 * Course:      Data Structures and Algorithms for Language Processing SS 2019
 * Assignment:  lab 4, 2
 * Author:      Lorena Martin Rodriguez
 * Description: A program to draw snowflakes
 * Honor Code:  I pledge that this program represents my own work.
 *              I received help from:
 *              the Github issues section
 *              in designing and debugging my program.
 */

import java.awt.*;
import java.applet.Applet;
import java.lang.Math;
import java.util.Random;

public class RandomSnowflake extends Applet {

    /**
     * Draw a snowflake like star at coordinate x, y on Canvas canvas
     * The beams of the star are beamLen pixels long
     */
    private void drawStar(Graphics canvas, int x, int y, int beamLen) {
        //create a stop case
        //since now the star can have different layers, we just limit the length to a distinguishable one
        if (beamLen <= 2) return;
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

        //Set background color
        setBackground(Color.white);

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
        // Draw the stars
        int numStars = randomizer(0,20)
        for (int i = 0; i < numStars; i++) {
            // Set snowflake color
            Color snowflake = new Color(randomizer(0, 150), randomizer(0, 150), randomizer(0, 150));
            gr.setColor(snowflake);
            //the star's center should be in the canvas and the length should be higher than the minimum one
            drawStar(gr, randomizer(0, width - 1), randomizer(0, height - 1), randomizer(3, maxLen));
        }
    }

    /**
     * Creates a random value in the provided range
     * @param minValue lowest value possible
     * @param maxValue highest value possible
     * @return a random value
     */
    private int randomizer(int minValue, int maxValue) {
        return new Random().nextInt(maxValue + 1 - minValue) + minValue;
    }
}
