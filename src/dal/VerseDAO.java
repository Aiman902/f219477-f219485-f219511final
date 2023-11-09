package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VerseDAO {
    private String filePath;

    public VerseDAO(String filePath) {
        this.filePath = filePath;
    }

    public void addVerseToFile(String verseText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(verseText);
            writer.newLine();
        }
    }

    public List<String> getVersesFromFile() throws IOException {
        List<String> verses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                verses.add(line);
            }
        }
        return verses;
    }
}
