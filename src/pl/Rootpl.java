package pl;

import dal.rootDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Rootpl {
    private rootDAO rootDAO;
    private JComboBox<String> rootDropdown;

    public Rootpl(rootDAO rootDAO) {
        this.rootDAO = rootDAO;

        JFrame frame = new JFrame("Root Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Welcome to the Root Viewer!");
        panel.add(titleLabel);

        rootDropdown = new JComboBox<>();
        panel.add(rootDropdown);

        JButton showRootButton = new JButton("Show Selected Root");
        panel.add(showRootButton);

        showRootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSelectedRoot();
            }
        });

        try {
            String[] roots = rootDAO.readRootsFromFile();

            for (String root : roots) {
                rootDropdown.addItem(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(rootDropdown);
        frame.add(showRootButton);

        frame.pack();
        frame.setVisible(true);
    }

    private void showSelectedRoot() {
        String selectedRoot = (String) rootDropdown.getSelectedItem();
        JOptionPane.showMessageDialog(null, "Selected Root: " + selectedRoot);
    }
}