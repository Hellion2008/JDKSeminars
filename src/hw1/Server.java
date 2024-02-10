package hw1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Server extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    private Map<String, String> dbClients;
    private List<String> historyChat;
    JButton btnStart, btnStop;
    Server (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Server");
        setResizable(true);
        historyChat = new ArrayList<>();
        dbClients = new HashMap<>();
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        JPanel beginPanel = new JPanel(new GridLayout(1,2));
        beginPanel.add(btnStart);
        beginPanel.add(btnStop);

        add(beginPanel,BorderLayout.SOUTH);
        setVisible(true);

    }

    public Map<String, String> getDbClients() {
        return dbClients;
    }

    public boolean checkAuthentication (String login, String password){
        if (dbClients.containsKey(login)){
            if (password.equals(dbClients.get(login))){
                return true;
            }
        }
        return false;
    }

    public List<String> getHistoryChat() {
        return historyChat;
    }
}
