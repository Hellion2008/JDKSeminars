package hw1;

public class Program {
    public static void main(String[] args) {
        Server server  = new Server();
        server.getDbClients().put("Batman", "Alfred");
        server.getDbClients().put("Joker", "chaos");
        server.getDbClients().put("1", "1");

        Client client1 = new Client(server);
//        Client client2 = new Client(server);
    }
}
