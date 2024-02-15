package hw1;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private static final String DEFAULT_IP = "127.0.0.1";
    private static final String SOCKET = "8189";
    private Server server;
    private JButton btnSend, btnLogin;
    private JTextField ip, socket, nickname, message;
    private JPasswordField password;
    Client (Server server){
        this.server = server;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Client");
        setResizable(true);

        ip = new JTextField(DEFAULT_IP);
        socket = new JTextField(SOCKET);
        nickname = new JTextField();
        password = new JPasswordField();
        btnLogin = new JButton("login");

        btnSend = new JButton("send");
        message = new JTextField();

        btnLogin.addActionListener(e -> {
            String login = nickname.getText();
            String pass = password.getText();
            if (server.checkAuthentication(login,pass)){
                new ChatClientWindow(Client.this);
            }
            Client.this.setName(login);
            server.getDafaultList().addElement(login + " присоединился к чату!");
            server.getListClientsOnline().add(this);

        });


        JPanel loginPanel = new JPanel(new GridLayout(2,3));
        JPanel sendPanel = new JPanel(new BorderLayout());
        loginPanel.add(ip);
        loginPanel.add(socket);
        loginPanel.add(new Label());
        loginPanel.add(nickname);
        loginPanel.add(password);
        loginPanel.add(btnLogin);

        sendPanel.add(btnSend,BorderLayout.EAST);
        sendPanel.add(message);

        add(loginPanel,BorderLayout.NORTH);
        add(sendPanel,BorderLayout.SOUTH);
        setVisible(true);
    }

    public Server getServer() {
        return server;
    }
}
