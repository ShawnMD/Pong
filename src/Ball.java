import java.awt.*;

public class Ball {
    //defines variables for the POSITION of the ball
    int x, y;
    //defines a variable for the WIDTH/HEIGHT of the ball. Since WIDTH = HEIGHT we will use diameter
    final int diameter = 50;

    //ball constructor to set initial position values
    public Ball(){
        x = 0;
        y = 0;
    }

    //method to set the position of the ball. Adjust the position to reflect where the user wants
    //the CENTER of the ball
    public void setPosition(int x, int y){
        this.x = x - diameter/2;
        this.y = y - diameter/2;
    }

    //paint method to render the ball graphics
    public void paint(Graphics g){
        g.fillOval(x, y, diameter, diameter);
    }
}
