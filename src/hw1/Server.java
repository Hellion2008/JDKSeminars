package hw1;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Server extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    private static boolean isRunning = false;

    private Map<String, String> dbClients;

    private Path log = Path.of(".\\log.txt");
    private DefaultListModel dafaultList;
    private final JList<String> historyLog;
    JButton btnStart, btnStop;

    private final List<Client> listClientsOnline;

    private JScrollPane historyLogScroll;
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
        historyLog.setLayoutOrientation(JList.VERTICAL);
        historyLog.setVisibleRowCount(0);

        historyLogScroll = new JScrollPane(historyLog);
        historyLogScroll.setPreferredSize(new Dimension(100, 100));

        JPanel beginPanel = new JPanel(new GridLayout(1,2));

        btnStop.addActionListener(e -> {
            stopServer();
        });

        btnStart.addActionListener(e -> {
            startServer();
        });
        beginPanel.add(btnStart);
        beginPanel.add(btnStop);

        dafaultList.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                String str = ".\\log.txt";
                if (Files.exists(Path.of(str))){
                    try {
                        Files.writeString(Paths.get(str),
                                new StringBuilder()
                                        .append(dafaultList.lastElement().toString())
                                        .append("\n"),
                                StandardOpenOption.APPEND);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        Files.createFile(Path.of(str));
                        Files.writeString(Paths.get(str),
                                new StringBuilder()
                                .append(dafaultList.lastElement().toString())
                                .append("\n"),
                                StandardOpenOption.APPEND);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {

            }

            @Override
            public void contentsChanged(ListDataEvent e) {

            }
        });

        add(beginPanel,BorderLayout.SOUTH);
        add(historyLogScroll);
        setVisible(true);
        historyLog.setVisible(false);

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

        historyLog.setVisible(true);
        dafaultList.addElement("Сервер запущен!");
    }

    public DefaultListModel getDafaultList() {
        return dafaultList;
    }

    public List<Client> getListClientsOnline() {
        return listClientsOnline;
    }

    public Path getLog() {
        return log;
    }
}
