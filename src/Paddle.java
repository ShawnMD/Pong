import java.awt.*;

public class Paddle {
    //variables to determine the coordinates of the paddle
    private int x, y;
    //variable to determine the size of the paddle
    private final int WIDTH = 20, HEIGHT = 100;

    public Paddle(){
        //initial coordinates of the paddle
        x = 0;
        y = 0;
    }

    public void setPosition(int x, int y){
        //sets the position of the paddle based on the MIDDLE of the paddle
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
    }

    public void paint(Graphics g){
        //renders the graphcis for the paddle
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}
