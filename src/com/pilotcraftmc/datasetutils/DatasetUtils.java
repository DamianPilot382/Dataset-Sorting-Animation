package com.pilotcraftmc.datasetutils;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JFrame;
public class DatasetUtils {

	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		JFrame frame = initialize();
		int width = frame.getWidth();
		int height = frame.getHeight();

		int[] arr = new int[250];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int) (Math.random() * 200);
			//System.out.println(arr[i]);
		}

		DataBarDisplayer dbd = new DataBarDisplayer(width, height, arr);
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
		
		System.out.println("Sorts:");
		System.out.println("1. Mergesort\n2. Quicksort\n3. Bubblesort");
		System.out.print("Select sorting algorithm number: ");
		int in = 0;
		int ms = 0;
		try{
			Scanner input = new Scanner(System.in);
			in = input.nextInt();
			System.out.print("Enter millisecond delay: ");
			ms = input.nextInt();
		} catch(Exception e){
			System.out.println("Invalid");
			Thread.sleep(1000);
			System.exit(0);
		}
		frame.setVisible(true);

		Thread.sleep(1000);
		switch(in){
			case 1:
				dbd.mergeSort(ms);
				break;
			case 2:
				dbd.quickSort(ms);
				break;
			case 3:
				dbd.bubbleSort(ms);
				break;
			default:
				System.out.println("Invalid");
				Thread.sleep(1000);
				System.exit(0);
				break;
		};
		
		System.out.println("Done!");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static JFrame initialize() {
		JFrame frame = new JFrame();

		frame.setSize(1080, 720);
		frame.getContentPane().setBackground(Color.BLACK);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Data sets");
		frame.setResizable(true);

		return frame;
	}

}