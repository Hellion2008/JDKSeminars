package hw1;

public class Program {
    public static void main(String[] args) {
        Server server  = new Server();
        new Client(server);
        new Client(server);
    }
}
