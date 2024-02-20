package hw2;

import hw2.client.ClientGUI;
import hw2.server.*;

public class Main {
    public static void main(String[] args) {
        Repository repository = new RepositoryImp();
        Server server = new Server(repository);
        ServerView serverWindow = new ServerWindow(server);
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
