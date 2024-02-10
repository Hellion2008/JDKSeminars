package hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    ChatClientWindow(Client client){
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
        chat = new JList<>(dafaultList);

        JPanel sendPanel = new JPanel(new BorderLayout());

        sendPanel.add(btnSend,BorderLayout.EAST);
        sendPanel.add(message);

        btnSend.addActionListener(e -> {
            writeToChat();
        });

        add(sendPanel,BorderLayout.SOUTH);
        add(chat);
        setVisible(true);
    }

    private void writeToChat(){
        String msg = client.getName() + ": " + message.getText();
        client.getServer().getHistoryChat().add(msg);
        dafaultList.addElement(msg);
    }

}
