//package pl;
//import javax.swing.*;
//import bll.PoemBO;
//import dal.PoemDAO;
//import dal.RootDAO;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Mainpl {
//    private PoemBO poemBO;
//
//    private JTextField poemTextField;
//    private JButton addPoemButton;
//    JFrame frame = new JFrame("Root Viewer");
//    JComboBox<String> rootDropdown = new JComboBox<>();
//
//    public Mainpl(PoemBO poemBO) {
//        this.poemBO = poemBO;
//
//        JFrame frame = new JFrame("Poem Application");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 150);
//
//        JPanel panel = new JPanel();
//        frame.add(panel);
//
//        panel.setLayout(new GridLayout(3, 1));
//
//        JLabel titleLabel = new JLabel("Welcome to the Poem Application!");
//        panel.add(titleLabel);
//
//        poemTextField = new JTextField();
//        panel.add(poemTextField);
//
//        addPoemButton = new JButton("Add Poem");
//        panel.add(addPoemButton);
//
//        addPoemButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addPoem();
//            }
//        });
//
//        try {
//            String[] roots = RootDAO.readRootsFromFile();
//
//            for (String root : roots) {
//                rootDropdown.addItem(root);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        JButton showRootButton = new JButton("Show Selected Root");
//        showRootButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selectedRoot = (String) rootDropdown.getSelectedItem();
//                JOptionPane.showMessageDialog(null, "Selected Root: " + selectedRoot);
//            }
//        });
//
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//        frame.add(rootDropdown);
//        frame.add(showRootButton);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void addPoem() {
//        String poemText = poemTextField.getText();
//        poemBO.addPoem(poemText);
//        JOptionPane.showMessageDialog(null, "Poem added to Poem.txt.");
//        poemTextField.setText("");
//    }
//
//    public static void main(String[] args) {
//        PoemDAO poemDAO = new PoemDAO("Poem.txt");
//        PoemBO poemBO = new PoemBO(poemDAO);
//        SwingUtilities.invokeLater(() -> new Mainpl(poemBO));
//    }
//    
//}
