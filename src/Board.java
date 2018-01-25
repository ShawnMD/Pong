import javax.swing.*;
import javax.swing.text.EditorKit;
import java.awt.*;

public class Board extends JPanel{
    //assigns the Ball data type to a variable ball
    Ball ball;
    Paddle pPaddle;
    Paddle cPaddle;
    private final int EDGESPACE = 50;

    public Board() {
        //sets the size JFrame.pack should use if its optimal
        setPreferredSize(new Dimension(800, 600));
        //sets the background color of the panel
        setBackground(Color.BLACK);
        //creates a new instance of the Ball class
        ball = new Ball();
        pPaddle = new Paddle();
        cPaddle = new Paddle();
    }

    public void GameStart(){
        ball.setPosition(getWidth()/2, getHeight()/2);
        pPaddle.setPosition(EDGESPACE, getHeight()/2);
        cPaddle.setPosition(getWidth() - EDGESPACE, getHeight()/2);
    }

    //Overrides JPanel's default paintComponent with our custom one
    @Override
    public void paintComponent(Graphics g){
        //Calls the JPanel default paintComponent - namely turning the background black
        super.paintComponent(g);
        //sets the rendering color to white
        g.setColor(Color.WHITE);
        //paints the ball object on the panel
        if(GAMESTATES.isPlay()){
            ball.paint(g);
            pPaddle.paint(g);
            cPaddle.paint(g);
        }
        else if(GAMESTATES.isMenu()){

        }

    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        //returns the LENGTH of the STRING parameter to the variable stringLen
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        //determines the center of the WIDTH parameter and subtracts the center of the length
        //to determine the X value to start the string
        int start = width/2 - stringLen/2;
        //prints s at the desired X position with adjustment and the desired y.
        g2d.drawString(s, start + XPos, YPos);
    }
}
