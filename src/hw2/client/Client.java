package hw2.client;

import hw2.server.Repository;
import hw2.server.Server;
import hw2.server.ServerView;
import hw2.server.ServerWindow;

public class Client {
    private View view;
    private String name;
    private ServerView serverWindow;

    private Server server;
    private boolean connected;

    public Client(View view, Server server, ServerView serverWindow) {
        this.view = view;
        this.server = server;
        this.serverWindow = serverWindow;

    }

    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = server.getRepository().getLog();
            if (log != null){
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }

    public void disconnectFromServer(){
        if (connected) {
            connected = false;
            server.disconnectUser(this);
            view.disconnectedFromServer();
            showOnWindow("Вы были отключены от сервера!");
        }
    }

    public void answerFromServer(String messageFromServer){
        showOnWindow(messageFromServer);
    }

    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                serverWindow.message(name + ": " + message);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    private void showOnWindow(String text) {
        view.sendMessage(text + "\n");
    }
}
