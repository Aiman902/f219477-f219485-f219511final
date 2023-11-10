package pl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dal.rootDAO;

public class Mainpl {
	 Versepl versepl;
    public Mainpl( Versepl versepl) {
    
    	this.versepl=versepl;
    	JFrame frame = new JFrame("Poem Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addPoemButton = new JButton("Add Poem");
        JButton assignToVerseButton = new JButton("Assign to Verse");
        JButton tokenizeVerseButton = new JButton("Tokenize Verse");

        panel.add(addPoemButton);
        panel.add(assignToVerseButton);
        panel.add(tokenizeVerseButton);

        addPoemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Poem logic here
            }
        });

        assignToVerseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	rootDAO root = new rootDAO("src\\roots.txt");
            	new Rootpl(root);
            }
        });

        tokenizeVerseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 versepl.display();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	   Versepl versepl = new Versepl();
    	   
    	  Rootpl root;
        SwingUtilities.invokeLater(() -> new Mainpl(versepl));
    }
}
