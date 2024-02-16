package hw1;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ChatClientWindow extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    private final static String PROBLEM_MSG = "Подключение не удалось";
    private final static String GREETING_MSG = "Вы успешно подключились!";
    private final JButton btnSend;
    private final JTextField message;
    private final JList<String> chat;
    private Client client;
    private DefaultListModel dafaultList;


    ChatClientWindow(Client client) throws IOException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(client);
        setTitle("Chat Client");
        setResizable(true);
        client.setVisible(false);
        this.client = client;

        btnSend = new JButton("send");
        message = new JTextField();

        dafaultList = new DefaultListModel<>();
        try{
            this.loadFromServerLog();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


        chat = new JList<>(dafaultList);
        chat.setLayoutOrientation(JList.VERTICAL);
        chat.setVisibleRowCount(0);

        JScrollPane chatScroll = new JScrollPane(chat);
        chatScroll.setPreferredSize(new Dimension(100, 100));

        JPanel sendPanel = new JPanel(new BorderLayout());

        sendPanel.add(btnSend,BorderLayout.EAST);
        sendPanel.add(message);

        btnSend.addActionListener(e -> {
            if (client.getServer().isRunning()){
                writeToChat();
            } else {
                dafaultList.addElement(PROBLEM_MSG);
            }
        });

        btnSend.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    if (client.getServer().isRunning()){
                        writeToChat();
                    } else {
                        dafaultList.addElement(PROBLEM_MSG);
                    }
                }
            }
        });

        add(sendPanel, BorderLayout.SOUTH);
        add(chatScroll);
//        add(chat);
        setVisible(true);

        client.getServer().getDafaultList().addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                dafaultList.addElement(
                        client.getServer().getDafaultList().lastElement());
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {

            }

            @Override
            public void contentsChanged(ListDataEvent e) {
            }
        });
    }

    private void loadFromServerLog() throws IOException {
        if (Files.exists(client.getServer().getLog())){
            List<String> tempList = Files.readAllLines(client.getServer().getLog());
            for (String line: tempList){
                dafaultList.addElement(line);
            }
        }
    }

    private void writeToChat(){
        String msg = client.getName() + ": " + message.getText();
        client.getServer().getDafaultList().addElement(msg);
    }
}
