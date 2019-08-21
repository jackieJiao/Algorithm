package swing;

import javax.swing.*;
import java.awt.*;

public class swingtest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame jFrame = new JFrame("jiaozhijun");
            jFrame.setSize(500,500);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });

    }
}
