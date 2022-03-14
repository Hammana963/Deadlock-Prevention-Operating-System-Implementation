/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl implements DiningServer {
    ReentrantLock keys[] = new ReentrantLock[5];
    Condition forks[] = new Condition[5];

    // make 5 keys in the constructor
    // make 5 chopsticks in the constructor
    public DiningServerImpl() {
        for(int i = 0; i < 5; i++) {
            keys[i] = new ReentrantLock();
            forks[i] = keys[i].newCondition();
        }
    }

    //override the takeForks function from DiningServer interface
    @Override
    public void takeForks(int philNumber) {
        //Philosophers try to grab the forks
        int phil = philNumber + 1;
        try {
            //if fork is available, grab it. Otherwise wait
            System.out.println("Philosopher " + phil + " is trying to grab a fork.");
            if(keys[philNumber].getHoldCount()>0)
                forks[philNumber].await();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    //override the returnForks function from DiningServer interface
    @Override
    public void returnForks(int philNumber) {
        //return the fork if someone needs it
        if(keys[philNumber].getHoldCount()>0)
            forks[philNumber].signal();
    }

}
