package pl;

import javax.swing.*;
import bll.PoemBO;
import dal.PoemDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Poempl {
    private PoemBO poemBO;

    private JTextField poemTextField;
    private JButton addPoemButton;

    public Poempl(PoemBO poemBO) {
        this.poemBO = poemBO;

        JFrame frame = new JFrame("Poem Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome to the Poem Application!");
        panel.add(titleLabel);

        poemTextField = new JTextField();
        panel.add(poemTextField);

        addPoemButton = new JButton("Add Poem");
        panel.add(addPoemButton);

        addPoemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPoem();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void addPoem() {
        String poemText = poemTextField.getText();
        poemBO.addPoem(poemText);
        JOptionPane.showMessageDialog(null, "Poem added to Poem.txt.");
        poemTextField.setText("");
    }

    public static void main(String[] args) {
        PoemDAO poemDAO = new PoemDAO("Poem.txt");
        PoemBO poemBO = new PoemBO(poemDAO);
        SwingUtilities.invokeLater(() -> new Poempl(poemBO));
    }
}
