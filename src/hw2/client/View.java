package hw2.client;

public interface View {
    void sendMessage(String message);
    void connectedToServer();
    void disconnectedFromServer();
}
