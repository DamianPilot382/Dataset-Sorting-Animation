package com.pilotcraftmc.datasetsortinganimation.sortingmethods;

import javax.swing.JPanel;

public class BubbleSort extends SortingMethod {
	
	@Override
	public void sort(JPanel panel, int ms, int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				repaintAndSleep(panel, ms);
				if (arr[j - 1] > arr[j])
					swap(arr, j-1, j);
			}
		}
	}
	
}
