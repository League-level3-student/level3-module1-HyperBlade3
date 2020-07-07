package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	static String currentWord = "";
	static String underScore = "";
	static JLabel label;
	static JFrame frame;
	static JPanel panel;
	int lives = 7;
	boolean containsChar = false;
	static Stack<String> words;
	static int wordAmount;

	public static void main(String[] args) {

		wordAmount = Integer.parseInt(JOptionPane.showInputDialog("How many words do you want between 0 and 266"));
		words = new Stack<String>();
		for (int i = 0; i < wordAmount; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (words.contains(word)) {
				words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			} else {
				words.push(word);
			}
		}

		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label.setSize(500, 500);
		frame.add(panel);
		panel.add(label);
		HangMan hangman = new HangMan();
		hangman.addListener();
		frame.setPreferredSize(new Dimension(200, 200));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		currentWord = words.pop();
		for (int i = 0; i < currentWord.length(); i++) {
			underScore += "_";
		}

		label.setText(underScore);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		char key = e.getKeyChar();
		for (int i = 0; i < currentWord.length(); i++) {
			if (currentWord.charAt(i) == key) {
				underScore = underScore.substring(0, i) + key + underScore.substring(i + 1, currentWord.length());
				label.setText(underScore);
				containsChar = true;
			}
		}
		if (containsChar == false) {
			lives--;
		}

		if (underScore.equals(currentWord)) {

			currentWord = words.pop();
			underScore = "";
			for (int i = 0; i < currentWord.length(); i++) {
				underScore += "_";

			}
			label.setText(underScore);
		}

		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "Game Over");
			frame.dispose();
			String answ = JOptionPane.showInputDialog("Would you like to play again?");
			if (answ.equals("yes")) {

				restart();
			}
		}

		if (words.size() == 0) {
			JOptionPane.showMessageDialog(null, "You completed all the words!");
			frame.dispose();
			String answ = JOptionPane.showInputDialog("Would you like to play again?");
			if (answ.equals("yes")) {

				restart();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void addListener() {
		frame.addKeyListener(this);

	}

	public void restart() {
		lives = 7;
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label.setSize(500, 500);
		frame.add(panel);
		panel.add(label);
		HangMan hangman = new HangMan();
		hangman.addListener();
		frame.setPreferredSize(new Dimension(200, 200));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		words = new Stack<String>();
		wordAmount = Integer.parseInt(JOptionPane.showInputDialog("How many words do you want between 0 and 266"));
		for (int i = 0; i < wordAmount; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (words.contains(word)) {
				words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			} else {
				words.push(word);
			}
		}
		currentWord = "";
		currentWord = words.pop();
		underScore = "";
		for (int i = 0; i < currentWord.length(); i++) {
			underScore += "_";

		}
		label.setText(underScore);
	}

}
