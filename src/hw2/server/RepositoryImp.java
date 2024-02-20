package hw2.server;

import java.io.FileReader;
import java.io.FileWriter;

public class RepositoryImp implements Repository{
    @Override
    public String getLog() {
        return readLog();
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(Repository.LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveInLog(String text){writeLog(text);}

    private void writeLog(String text){
        try (FileWriter writer = new FileWriter(Repository.LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
