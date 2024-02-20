package hw2.server;

import java.awt.*;

public interface ServerView {

    void message(String text);
    void createPanel();

    Server getServer();
}
