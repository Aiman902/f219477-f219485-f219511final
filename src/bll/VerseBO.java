package bll;

import dal.VerseDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerseBO {
    private VerseDAO verseDAO;

    public VerseBO(VerseDAO verseDAO) {
        this.verseDAO = verseDAO;
    }

    public void addVerse(String verseText) {
        try {
            verseDAO.addVerseToFile(verseText);
            System.out.println("Verse added successfully.");
        } catch (IOException e) {
            System.err.println("Error adding verse: " + e.getMessage());
        }
    }

    public List<String> getVerses() {
        try {
            return verseDAO.getVersesFromFile();
        } catch (IOException e) {
            System.err.println("Error retrieving verses: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<String> tokenizeVerse(String verse) {
        return Arrays.asList(verse.split("\\s+"));
    }
}
