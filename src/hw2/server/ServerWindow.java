package hw2.server;

import hw2.client.Client;
import hw2.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame implements ServerView{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private Server server;

    private JButton btnStart, btnStop;
    private JTextArea log;

    public ServerWindow(Server server){
        this.server = server;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }
    @Override
    public void message(String text){
        if (!server.isWork()){
            return;
        }
        appendLog(text);
        server.message(text);
    }

    private void appendLog(String text){
        log.append(text + "\n");
    }
    @Override
     public void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    @Override
    public Server getServer() {
        return server;
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(e -> {
            if (server.isWork()){
                appendLog("Сервер уже был запущен");
            } else {
                server.setWork(true);
                appendLog("Сервер запущен!");
            }
        });

        btnStop.addActionListener(e -> {
            if (!server.isWork()){
                appendLog("Сервер уже был остановлен");
            } else {
                server.setWork(false);
                server.cleanClientList();
                appendLog("Сервер остановлен!");
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }


}