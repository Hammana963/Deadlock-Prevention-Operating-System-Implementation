/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl  implements DiningServer
{  
        // states of philosphers
        enum State {THINKING, HUNGRY, EATING};
        
        public static final int NUM_PHILOSOPHERS = 5;
        
        // keeps record of philosphers and current state
        private State[] state;
        
        public DiningServerImpl()
        {
                state = new State[NUM_PHILOSOPHERS];
                
                // init all philosophers to thinking
                for (int i = 0; i < NUM_PHILOSOPHERS; i++)
                        state[i] = State.THINKING;
        }
        
        public void takeForks(int pnum)  {
                state[pnum] = State.HUNGRY;
        }
        
        public void returnForks(int pnum) {
                state[pnum] = State.THINKING;
        }
        
}