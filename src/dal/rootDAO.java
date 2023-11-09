package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RootDAO {
    private String fileName;

    public RootDAO(String fileName) {
        this.fileName = fileName;
    }

    public String[] readRootsFromFile() throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+"); // Split by whitespace
            for (String word : words) {
                sb.append(word);
                sb.append(System.lineSeparator());
            }
        }
        bufferedReader.close();
        return sb.toString().split(System.lineSeparator());
    }
}
