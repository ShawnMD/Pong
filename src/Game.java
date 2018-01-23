import javax.swing.*;

//Inheritance - when one class "inhereits" or has access to all the methods/fields of its
//              parent class. We use SUPER CLASS as the parent and SUB CLASS as the child.
//              extends is the keyword that applies a superclass to a subclass.

public class Game extends JFrame {

    Board board;

    public Game(){
        //enables/disables user ability to change frame size
        setResizable(false);
        //enables/disables whether the frame renders on screen
        //*************************
        setVisible(true);
        //*************************
        //enables/disables whether the frame can be an active window
        setFocusable(true);
        //sets the text in the title bar of the frame
        setTitle("PONG");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //creates an instance of the Board class
        board = new Board();
        //adds the board panel to the frame
        add(board);
        //packages all components and determines best layout/size
        pack();
        //centers the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        // calls a new instance of the game class - runs the constructor
        new Game();
    }

}
