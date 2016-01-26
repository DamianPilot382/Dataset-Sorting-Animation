package com.pilotcraftmc.sortinggrapher;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The {@code SortingGrapher} class is the main class of the application.
 * <p>
 * It initializes the {@code JFrame} and prompts the user for input.
 * </p>
 * <p>
 * This class is <b>not</b> thread-safe and will throw an {@code InterruptedException} if interrupted.
 * </p>
 * 
 * @author Leon Montealegre
 * @author Damian Ugalde
 * @version 0.05
 */
public class SortingGrapher {
	
	/**
	 * Launches the application.
	 * 
	 * @throws 	InterruptedException
	 * 				If the main thread is interrupted while sleeping.
	 */
	public static void main(String[] args) throws InterruptedException{
		JFrame frame = initialize();
		int width = frame.getWidth();
		int height = frame.getHeight();
		
		int index = JOptionPane.showOptionDialog(null, "Sorting Methods : ", "Sorting Methods", JOptionPane.DEFAULT_OPTION, 
													JOptionPane.PLAIN_MESSAGE, null, DataBarDisplayer.SORTING_METHOD_NAMES, 
														DataBarDisplayer.SORTING_METHOD_NAMES[0]);
		String msInput;
		do {
			msInput = JOptionPane.showInputDialog("Enter milliseconds delay: ");
		} while(!isInteger(msInput));
		int ms = Integer.valueOf(msInput);
		
		boolean rainbow = JOptionPane.showOptionDialog(null, "Rainbow?", "Rainbow", JOptionPane.YES_NO_OPTION, 
														JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, 
															"Yes") == 0;
		
		String sizeInput;
		do {
			sizeInput = JOptionPane.showInputDialog("Enter size of the array: ");
		} while(!isInteger(sizeInput));
		int size = Integer.valueOf(sizeInput);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++)
			list.add(i);
		Collections.shuffle(list);
		int[] arr = new int[size];
		for(int i = 0; i < size; i++)
			arr[i] = list.get(i);
		
		DataBarDisplayer dbd = new DataBarDisplayer(width, height, arr, rainbow);
		dbd.setFocusable(true);
		dbd.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_Q)
					System.exit(0);
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		dbd.setVisible(true);
		frame.getContentPane().add(dbd);
		
		frame.setVisible(true);

		Thread.sleep(1000);
		dbd.sort(index, ms);
	}
	
	/**
	 * Determines if the specified String is an integer.
	 * <p>
	 * A String is an integer if every character is a number between 0-9
	 * or a - symbol.
	 * </p>
	 * 
	 * @param	str
	 * 				The String to be tested.
	 * 
	 * @return	{@code true} if the given String was an integer,
	 * 				{@code false} otherwise.
	 */
	private static boolean isInteger(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!(Character.isDigit(c) || c == '-'))
				return false;
		}
		return true;
	}

	/**
	 * Initializes the contents of the frame.
	 * 
	 * @return	A default JFrame.
	 */
	private static JFrame initialize(){
		JFrame frame = new JFrame();

		frame.setSize(1080, 720);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Data sets");
		frame.setResizable(true);

		return frame;
	}

}