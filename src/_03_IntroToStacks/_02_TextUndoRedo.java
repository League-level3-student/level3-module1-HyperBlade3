package _03_IntroToStacks;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener, ActionListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	public static void main(String[] args) {
		_02_TextUndoRedo textEditor = new _02_TextUndoRedo();

	}
	
	Stack<Character> labelText = new Stack<Character>();
	Stack<Character> deletedChar = new Stack<Character>();

	JFrame frame;

	JPanel panel;

	JLabel label;
	
	int x;

	public _02_TextUndoRedo() {
		frame = new JFrame();
		panel = new JPanel();
		frame.getContentPane();
		label = new JLabel();
		Dimension size = label.getPreferredSize();
		label.setBounds(500, 450, size.width, size.height);
		
		panel.add(label);
		panel.setBorder(BorderFactory.createEmptyBorder(250, 500,250,500));
		frame.addKeyListener(this);
		frame.add(panel, BorderLayout.CENTER);
		
		panel.setVisible(true);
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && labelText.size() > 0) {
			
			deletedChar.push(labelText.pop());
			
		}
		else if (labelText.size() == 0 && e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_CONTROL && deletedChar.size() > 0) {
			System.out.println("Work");
			labelText.push(deletedChar.pop());
		}
		
		else {
			labelText.push(e.getKeyChar());
			
		}
		String x = "";
 		for (char i : labelText) {
 			x += i;
 		}
 		label.setText(x);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		

		
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
