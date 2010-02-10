package bjornno.javabatch;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.Executors;

public class FileScannerScheduledTest {

    @Test
    public void testWriteAndScanManyFiles() throws InterruptedException {
        String dir = "c:\\temp\\test\\";
        BatchFileWriter writer = new BatchFileWriter(dir);
        for(int i = 0; i<50; i++) {
            writer.write("testfile"+i, "Testdata"+i);
        }
        BatchFileScanScheduler scheduler = new BatchFileScanScheduler(new BatchFileReciever() {
            public void recieve(Reader reader) {
                BufferedReader rdr = new BufferedReader(reader);
                try {
                    System.out.println(rdr.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, dir);

        Executors.newFixedThreadPool(1).execute(scheduler);

        Thread.sleep(4000);
        System.exit(0);


    }
}
