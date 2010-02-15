package bjornno.javabatch;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class StupidThreadedStarter {
    private BatchFileScanManager workManager;

    public StupidThreadedStarter(BatchFileScanManager workManager) {
        this.workManager = workManager;
    }

    public void setWorkManager(BatchFileScanManager workManager) {
        this.workManager = workManager;
    }

    public void start() {
        System.out.println("Starting asynchwork scanner.");
        Executor executor = Executors.newFixedThreadPool(1);
        //  while(true) {
        executor.execute(workManager);
        //      try {
        //          Thread.currentThread().sleep(5000);
        //      } catch (InterruptedException e) {
        //          throw new RuntimeException(e);
        //      }
        //  }
    }
}
