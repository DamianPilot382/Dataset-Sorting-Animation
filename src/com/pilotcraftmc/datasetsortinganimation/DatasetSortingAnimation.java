package com.pilotcraftmc.datasetsortinganimation;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class DatasetSortingAnimation {
	
	public static final Object[] methodList = {"Mergesort", "Quicksort", "Bubblesort", "Insertionsort", "Bozosort", "Bogosort"};
	
	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException{
		
		JFrame frame = initialize();
		int width = frame.getWidth();
		int height = frame.getHeight();
		
		int in = JOptionPane.showOptionDialog(null, "Sorting Methods : ", "Sorting Methods", JOptionPane.DEFAULT_OPTION, 
												JOptionPane.PLAIN_MESSAGE, null, methodList, methodList[0]);
		String msInput;
		do {
			msInput = JOptionPane.showInputDialog("Enter milliseconds delay: ");
		} while(!isInteger(msInput));
		int ms = Integer.valueOf(msInput);
		
		boolean rainbow = JOptionPane.showOptionDialog(null, "Rainbow?", "Rainbow", JOptionPane.YES_NO_OPTION, 
														JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes") == 0;
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
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_Q)
					System.exit(0);
			}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
		});
		dbd.setVisible(true);
		frame.getContentPane().add(dbd);
		
		frame.setVisible(true);

		Thread.sleep(1000);
		switch(in) {
			case 0:
				dbd.mergeSort(ms); break;
			case 1:
				dbd.quickSort(ms); break;
			case 2:
				dbd.bubbleSort(ms); break;
			case 3:
				dbd.insertionSort(ms); break;
			case 4:
				dbd.bozoSort(ms); break;
			case 5:
				dbd.bogoSort(ms); break;
		}
		
	}
	
	private static boolean isInteger(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!(Character.isDigit(c) || c == '-'))
				return false;
		}
		return true;
	}

	/**
	 * Initialize the contents of the frame.
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