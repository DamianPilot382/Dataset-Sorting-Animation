package com.pilotcraftmc.sortinggrapher.sortingmethods;

import javax.swing.JPanel;

import com.pilotcraftmc.sortinggrapher.Tone;

/**
 * The {@code SortingMethod} class is an abstract class to represent each sorting method in the application.
 * <p>
 * It also provides some utilities for each sorting method such as
 * <ul>
 * <li>Checking if an array is sorted.</li>
 * <li>Swapping two elements in an array.</li>
 * <li>Repainting and thread-safely sleeping the given interval.</li>
 * </ul>
 * </p>
 * 
 * @author Leon Montealegre
 * @author Damian Ugalde
 * @version 0.01
 */
public abstract class SortingMethod {
	
	protected SortingMethod() {}
	
	public abstract void sort(JPanel panel, int ms, int[] arr);
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	protected static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}
	
	protected static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	protected static void repaintAndSleep(JPanel panel, int ms) {
		panel.repaint();
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
