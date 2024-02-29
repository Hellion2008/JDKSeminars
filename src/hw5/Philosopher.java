package hw5;

public class Philosopher extends Thread{

    private volatile boolean[] forks;

    private int place;
    private int count = 1;

    public Philosopher(String name, boolean[] forks, int place) {
        this.setName(name);
        this.forks = forks;
        this.place = place;
    }

    private void think() throws InterruptedException {
        System.out.println(getName() + " thinks...");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        changeForks();
        System.out.println(getName() + " eats " + count + " times");
        count++;
        changeForks();
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        System.out.println(getName());
        while(count <=3) {
            if (checkForks()) {
                try {
                    this.eat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    think();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(getName() + " doesn't want to eat");
    }

    private boolean checkForks(){
        if (place == 0){
            return forks[0] && forks[forks.length-1];
        }
        return forks[place] && forks[place-1];
    }

    private synchronized void changeForks(){
//        synchronized (forks){
            if (place == 0){
                forks[0] = !forks[0];
                forks[forks.length-1] = !forks[forks.length-1];
            } else {
                forks[place] = !forks[place];
                forks[place - 1] = !forks[place - 1];
            }
//        }
    }


}
