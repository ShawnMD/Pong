import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{

    public Board() {
        //sets the size JFrame.pack should use if its optimal
        setPreferredSize(new Dimension(800, 600));
        //sets the background color of the panel
        setBackground(Color.BLACK);
    }
}
