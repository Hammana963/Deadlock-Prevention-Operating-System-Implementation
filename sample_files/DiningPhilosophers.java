/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */

public class DiningPhilosophers
{  
   public static void main(String args[])
   {
      DiningServer server = new DiningServerImpl();

      Philosopher[] pArr = new Philosopher[DiningServerImpl.NUM_PHILOSOPHERS];
     
     // create the philosopher threads
     for (int i = 0; i < DiningServerImpl.NUM_PHILOSOPHERS; i++)
        pArr[i] = new Philosopher(server,i);
     
    // start threads 
     for (int i = 0; i < DiningServerImpl.NUM_PHILOSOPHERS; i++)
         new Thread(pArr[i]).start();
   }
}