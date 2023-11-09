package pl;

import bll.VerseBO;
import dal.VerseDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class Mainpl {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Verse Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            String filePath = "C:\\Users\\AIMA\\Desktop\\f219485-f219511final\\poem.txt"; 

            VerseDAO verseDAO = new VerseDAO(filePath);
            VerseBO verseBO = new VerseBO(verseDAO);

            DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Verse"}, 0);
            JTable verseTable = new JTable(tableModel);

            JTextArea verseTextArea = new JTextArea(3, 30);
            JButton addVerseButton = new JButton("Add Verse");
            JButton viewVerseButton = new JButton("View Verses");

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            panel.add(verseTextArea);
            panel.add(addVerseButton);
            panel.add(viewVerseButton);

            addVerseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String verseText = verseTextArea.getText();
                    verseBO.addVerse(verseText);
                    verseTextArea.setText("");
                }
            });

            viewVerseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<String> verses = verseBO.getVerses();
                    if (verses != null) {
                        tableModel.setRowCount(0); // Clear the table
                        for (String verse : verses) {
                            tableModel.addRow(new Object[]{verse});
                        }
                    }
                }
            });

            verseTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = verseTable.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        String selectedVerse = (String) tableModel.getValueAt(row, 0);
                        List<String> words = verseBO.tokenizeVerse(selectedVerse);
                        openWordTableView(words);
                    }
                }
            });

            frame.add(panel, BorderLayout.NORTH);
            frame.add(new JScrollPane(verseTable), BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    private static void openWordTableView(List<String> words) {
        JFrame wordFrame = new JFrame("Verse Words");
        wordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wordFrame.setSize(300, 300);

        DefaultTableModel wordTableModel = new DefaultTableModel(new Object[]{"Word"}, 0);
        JTable wordTable = new JTable(wordTableModel);

        for (String word : words) {
            wordTableModel.addRow(new Object[]{word});
        }

        wordFrame.add(new JScrollPane(wordTable));

        wordFrame.setVisible(true);
    }
}