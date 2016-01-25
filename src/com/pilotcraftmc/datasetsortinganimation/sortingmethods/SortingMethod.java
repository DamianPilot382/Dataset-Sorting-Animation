package com.pilotcraftmc.datasetsortinganimation.sortingmethods;

import javax.swing.JPanel;

public abstract class SortingMethod {
	
	protected SortingMethod() {}
	
	public abstract void sort(JPanel panel, int ms, int[] arr);
	
	public String getName() {
		return this.getClass().getName();
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
