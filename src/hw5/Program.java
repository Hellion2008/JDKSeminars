package hw5;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        boolean[] forks = {true, true, true,true,true};

        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            philosophers.add(new Philosopher("P_" + i,forks,i));
            philosophers.get(i).start();
        }
    }
}
