import java.util.concurrent.locks.*;

/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers {

   public static void main(String[] args) {

      //loop to to create 5 philosophers and test them
      DiningServer test = new DiningServerImpl();
      for(int i = 0; i < 5; i++) {
         new Philosopher(i, test).start();
      }

   }

}
