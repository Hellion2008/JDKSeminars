package hw2.server;

import hw2.client.Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Server{

    private Repository repository;

    private ServerView serverView;

    private boolean work;

    private List<Client> clientList;

    public Server(Repository repository) {
        clientList = new ArrayList<>();
        this.repository = repository;
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.answerFromServer(text);
        }
    }

    public void message(String text){
        answerAll(text);
        repository.saveInLog(text);
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnectFromServer();
        }
    }

    public void cleanClientList(){
        while (!clientList.isEmpty()){
            disconnectUser(clientList.get(clientList.size()-1));
        }
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public Repository getRepository() {
        return repository;
    }
}
