package com.pilotcraftmc.datasetsortinganimation.sortingmethods;

import javax.swing.JPanel;

public class MergeSort extends SortingMethod {
	
	@Override
	public void sort(JPanel panel, int ms, int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, panel, ms, tmp, 0, arr.length - 1);
		repaintAndSleep(panel, ms);
	}
	
	private void mergeSort(int[] arr, JPanel panel, int ms, int[] tmp, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(arr, panel, ms, tmp, left, center);
			mergeSort(arr, panel, ms, tmp, center + 1, right);
			repaintAndSleep(panel, ms);
			merge(arr, tmp, left, center + 1, right);
		}
	}
	
	private void merge(int[] arr, int[] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
	
		while (left <= leftEnd && right <= rightEnd)
			tmp[k++] = arr[(arr[left] <= arr[right]) ? (left++) : (right++)];
		while (left <= leftEnd)
			tmp[k++] = arr[left++];
		while (right <= rightEnd)
			tmp[k++] = arr[right++];
		for (int i = 0; i < num; i++, rightEnd--)
			arr[rightEnd] = tmp[rightEnd];
	}

}
