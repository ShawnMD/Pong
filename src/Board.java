import javax.swing.*;
import javax.swing.text.EditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{
    //assigns the Ball data type to a variable ball
    Ball ball;
    //assigns the Paddle data type to a player and computer variable
    Paddle pPaddle;
    Paddle cPaddle;
    Timer timer;
    //variables used to determine how far to render graphics from the border of the panel
    private final int EDGESPACE = 50;
    //variables used to determine sizes for board decorations
    private final int DECORSIZE = 25;

    public Board() {
        //sets the size JFrame.pack should use if its optimal
        setPreferredSize(new Dimension(800, 600));
        //sets the background color of the panel
        setBackground(Color.BLACK);
        //creates a new instance of the Ball class
        ball = new Ball(this);
        pPaddle = new Paddle();
        cPaddle = new Paddle();
    }
    //method to initialize the game
    public void GameStart(){
        //initial rendering position of graphics
        ball.setPosition(getWidth()/2, getHeight()/2);
        pPaddle.setPosition(EDGESPACE, getHeight()/2);
        cPaddle.setPosition(getWidth() - EDGESPACE, getHeight()/2);
        timer = new Timer(1000 / 60, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ball.move();
        repaint();

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
            //Render Objects
            ball.paint(g);
            pPaddle.paint(g);
            cPaddle.paint(g);
            //Render Goalline for Player
            g.drawLine(EDGESPACE, 0, EDGESPACE,getHeight());
            //Render Goaline for Computer
            g.drawLine(getWidth()-EDGESPACE, 0, getWidth()-EDGESPACE, getHeight());
            //Center Circle Outline
            g.drawOval(getWidth()/2 - (EDGESPACE*2), getHeight()/2 - (EDGESPACE * 2), EDGESPACE*4, EDGESPACE*4);
            //Dashes down the center
            int numDashes = getHeight() / DECORSIZE;
            for(int i = 0; i < numDashes; i++){
                g.drawLine(getWidth()/2, (i*DECORSIZE+DECORSIZE/4), getWidth()/2, (i*DECORSIZE)+(int)(DECORSIZE*(3.0/4)));
            }
        }
        else if(GAMESTATES.isMenu()){
            //Renders the Menu Board
            g.setFont(new Font("Serif", Font.BOLD, 36));
            printSimpleString("PONG", getWidth(), 0, (int)getHeight()/3, g);
            printSimpleString("Press *SPACE* to start.", getWidth(), 0, (int)(getHeight()*(2.0/3)), g);

        }
        else if(GAMESTATES.isPause()){
            //Renders the Pause Board
            g.setFont(new Font("Serif", Font.BOLD, 36));
            printSimpleString("PAUSED", getWidth(), 0, (int)getHeight()/3, g);
            printSimpleString("Press *P* to resume.", getWidth(), 0, (int)(getHeight()*(2.0/3)), g);
        }
        else if(GAMESTATES.isEnd()){
            //Renders the End Game Screen
            g.setFont(new Font("Serif", Font.BOLD, 36));
            printSimpleString("GAME OVER", getWidth(), 0, (int)getHeight()/3, g);
            printSimpleString("Press *SPACE* to begin again.", getWidth(), 0, (int)(getHeight()*(2.0/3)), g);
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
