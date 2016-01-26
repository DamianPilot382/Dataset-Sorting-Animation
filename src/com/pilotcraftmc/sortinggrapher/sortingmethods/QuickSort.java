package com.pilotcraftmc.sortinggrapher.sortingmethods;

import javax.swing.JPanel;

public class QuickSort extends SortingMethod {

	@Override
	public void sort(JPanel panel, int ms, int[] arr) {
		quickSort(arr, panel, ms, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, JPanel panel, int ms, int low, int high) {
		repaintAndSleep(panel, ms);
		int i = low, j = high;
		int pivot = arr[low + (high - low) / 2];

		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			if (i <= j)
				swap(arr, i++, j--);
		}

		if (low < j)
			quickSort(arr, panel, ms, low, j);
		if (i < high)
			quickSort(arr, panel, ms, i, high);
	}

}
