package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		
		Stack<Double> array = new Stack<Double>();
		
		Random random = new Random();
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		
		for (int i = 0; i < 100; i++) {
			array.push(random.nextDouble() * 100);
		}
		
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter in a number between 0 and 100, inclusive"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter in a number between 0 and 100, inclusive"));
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		
		for (int i = 0; i < array.size(); i++) {
	
			double x = array.pop();
			if (num1 > num2) {
				if (num2 < x && x < num1) {
					System.out.println(x);
				}
			}
			else if (num1 < num2) {
				if (num1 < x && x < num2) {
					System.out.println(x);
				}
			}
			
			
			
		}
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
