package com.pilotcraftmc.sortinggrapher.sortingmethods;

import javax.swing.JPanel;

public class InsertionSort extends SortingMethod {
	
	@Override
	public void sort(JPanel panel, int ms, int arr[]) {
		int n = arr.length;
		for (int j = 1; j < n; j++) {
			int key = arr[j];
			int i = j - 1;
			while ((i >= 0) && (arr[i] > key))
				arr[i + 1] = arr[i--];
			arr[i + 1] = key;
			repaintAndSleep(panel, ms);
		}
	}
	
}
