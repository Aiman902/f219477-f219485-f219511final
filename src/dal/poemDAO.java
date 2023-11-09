package dal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PoemDAO {
    private String fileName;

    public PoemDAO(String fileName) {
        this.fileName = fileName;
    }

    public void addPoem(String poemText) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(poemText);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("An error occurred while adding the poem: " + e.getMessage());
        }
    }
}
