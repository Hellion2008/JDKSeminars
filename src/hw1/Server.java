package hw1;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Server extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    private static boolean isRunning = false;

    private Map<String, String> dbClients;
    private DefaultListModel dafaultList;
    private final JList<String> historyLog;
    JButton btnStart, btnStop;

    private final List<Client> listClientsOnline;
    Server (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Server");
        setResizable(true);
        dbClients = new HashMap<>();
        listClientsOnline = new ArrayList<>();
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        dafaultList = new DefaultListModel<>();
        historyLog = new JList<>(dafaultList);

        JPanel beginPanel = new JPanel(new GridLayout(1,2));

        btnStop.addActionListener(e -> {
            stopServer();
        });

        btnStart.addActionListener(e -> {
            startServer();
        });
        beginPanel.add(btnStart);
        beginPanel.add(btnStop);

        add(beginPanel,BorderLayout.SOUTH);
        setVisible(true);

    }

    public Map<String, String> getDbClients() {
        return dbClients;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean checkAuthentication (String login, String password){
        if (dbClients.containsKey(login)){
            if (password.equals(dbClients.get(login))){
                return true;
            }
        }
        return false;
    }

    private void stopServer(){
        isRunning = false;
        dafaultList.addElement("Сервер отключен!");
    }

    private void startServer(){
        dafaultList.clear();
        isRunning = true;

        add(historyLog);
        dafaultList.addElement("Сервер запущен!");
    }

    public DefaultListModel getDafaultList() {
        return dafaultList;
    }

    public List<Client> getListClientsOnline() {
        return listClientsOnline;
    }
}
