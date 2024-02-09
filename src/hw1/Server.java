package hw1;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    JButton btnStart, btnStop;
    Server (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Server");
        setResizable(true);
        btnStart = new JButton("Start");
        btnStop = new JButton("Exit");
        JPanel beginPanel = new JPanel(new GridLayout(1,2));
        beginPanel.add(btnStart);
        beginPanel.add(btnStop);

        add(beginPanel,BorderLayout.SOUTH);
        setVisible(true);

    }
}
