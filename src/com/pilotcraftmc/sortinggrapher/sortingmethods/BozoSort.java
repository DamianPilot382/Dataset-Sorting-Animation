package com.pilotcraftmc.sortinggrapher.sortingmethods;

import javax.swing.JPanel;

public class BozoSort extends SortingMethod {
	
	@Override
	public void sort(JPanel panel, int ms, int[] arr) {
		while (!isSorted(arr)) {
			int i1 = (int) (Math.random() * arr.length);
			int i2 = (int) (Math.random() * arr.length);
			while (i1 == i2)
				i2 = (int)(Math.random() * arr.length);
			swap(arr, i1, i2);
			repaintAndSleep(panel, ms);
		}
	}
	
}
