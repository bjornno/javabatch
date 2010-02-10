package bjornno.javabatch;

import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class FileReadAndWriteTest {
    @Test
    public void testGetOneFile() throws IOException {
        String exampletekst = "Hei på deg\ndin gamle blei";
        String testDirectory = "c:\\temp\\test";
        BatchFileWriter writer = new BatchFileWriter(testDirectory);
        writer.write("exampleFile", exampletekst);
        BatchFileReader reader = new BatchFileReader(testDirectory);
        Reader rdr = reader.getOneFile();
        BufferedReader bfrdr = new BufferedReader(rdr);
        String line = bfrdr.readLine();
        String res = "";
        while (line != null) {
            res += line;
            line = bfrdr.readLine();
            if (line != null) res += "\n";
        }
        Assert.assertEquals(exampletekst, res);
    }


}
