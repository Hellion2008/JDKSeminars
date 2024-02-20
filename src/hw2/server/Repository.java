package hw2.server;

public interface Repository {

    static final String LOG_PATH = "src/hw2/server/log.txt";

    String getLog();

    void saveInLog(String text);




}
