package hw1;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private static final String DEFAUL_IP = "127.0.0.1";
    private static final String SOCKET = "8189";
    private Server server;
    JButton btnSend, btnLogin;
    JTextField ip, socket, nickname;
    JPasswordField password;
    Client (Server server){
        this.server = server;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Client");
        setResizable(true);

        ip = new JTextField(DEFAUL_IP);
        socket = new JTextField(SOCKET);
        nickname = new JTextField();
        password = new JPasswordField();

        btnLogin = new JButton("login");
        btnSend = new JButton("send");

        JPanel loginPanel = new JPanel(new GridLayout(2,3));
        JPanel sendPanel = new JPanel(new BorderLayout());
        loginPanel.add(ip);
        loginPanel.add(socket);
        loginPanel.add(new Label());
        loginPanel.add(nickname);
        loginPanel.add(password);
        loginPanel.add(btnLogin);

        sendPanel.add(btnSend,BorderLayout.EAST);

        add(loginPanel,BorderLayout.NORTH);
        add(sendPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
}
