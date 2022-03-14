/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */

public class Philosopher extends Thread implements Runnable{
    int philosopherNumber;
    DiningServer ds;

    //Initialize Philosopher number and Dining Server in constructor
    public Philosopher(int pNo, DiningServer ds) {
        philosopherNumber = pNo;
        this.ds = ds;
    }

    @Override
    public void run() {
        int sleepTime;
        while (true) {
            try {
                //Try to take both the chopticks
                ds.takeForks(philosopherNumber);
                System.out.println("Philosopher " + (philosopherNumber + 1) + " is eating.");
                //Got both the chopticks. Not eat
                sleepTime = (int) ((Math.random() * (3000 - 1000)) + 1000);
                System.out.println("Philosopher " + (philosopherNumber + 1) + " ate for " + sleepTime / (float)1000 + " seconds");
                Thread.sleep(sleepTime);
                //Eating complete. Return both the chopsticks and start thinking
                ds.returnForks(philosopherNumber);
                sleepTime = (int) ((Math.random() * (3000 - 1000)) + 1000);
                System.out.println("Philosopher " + (philosopherNumber + 1) + " thinking for " + sleepTime / (float)1000 + " seconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
