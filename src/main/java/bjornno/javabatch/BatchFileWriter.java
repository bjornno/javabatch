package bjornno.javabatch;

import java.io.*;


public class BatchFileWriter {
    private String directory;

    public BatchFileWriter(String directory) {
        this.directory = directory;
    }

    public void write(String filename, String content) {
        File file = new File(directory + "\\tmp\\" + filename);
        try {
            new File(directory + "\\tmp\\").mkdirs();
            Writer output = new BufferedWriter(new FileWriter(directory + "\\tmp\\" + filename));
            output.write(content);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        file.renameTo(new File(directory + "\\" + filename));
    }
}
