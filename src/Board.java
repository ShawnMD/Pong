import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{
    //assigns the Ball data type to a variable ball
    Ball ball;

    public Board() {
        //sets the size JFrame.pack should use if its optimal
        setPreferredSize(new Dimension(800, 600));
        //sets the background color of the panel
        setBackground(Color.BLACK);
        //creates a new instance of the Ball class
        ball = new Ball();
        /*ball.setPosition(this.getHeight()/2, this.getWidth()/2);
        System.out.println(this.getHeight());*/

        //WHAT COMMAND IS RAN WHEN THE BOARD IS FINISHED CONSTRUCTING?
    }

    //Overrides JPanel's default paintComponent with our custom one
    @Override
    public void paintComponent(Graphics g){
        //Calls the JPanel default paintComponent - namely turning the background black
        super.paintComponent(g);
        //sets the rendering color to white
        g.setColor(Color.WHITE);
        //paints the ball object on the panel
        ball.paint(g);
    }
}
