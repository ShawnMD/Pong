import javax.swing.*;

//Inheritance - when one class "inhereits" or has access to all the methods/fields of its
//              parent class. We use SUPER CLASS as the parent and SUB CLASS as the child.
//              extends is the keyword that applies a superclass to a subclass.

public class Game extends JFrame {

    Board board;

    public Game(){

        setResizable(false);

        //*************************
        setVisible(true);
        //*************************

        setFocusable(true);
        setTitle("PONG");
        board = new Board();

        add(board);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
         new Game();
    }

}
