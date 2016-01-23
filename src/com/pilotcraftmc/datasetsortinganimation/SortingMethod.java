package com.pilotcraftmc.datasetsortinganimation;

import javax.swing.JPanel;

public class SortingMethod {

	public static void quickSort(int[] arr, JPanel panel, int ms) {
		quickSort(arr, panel, ms, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, JPanel panel, int ms, int low, int high) {
		panel.repaint();
		sleep(ms);
		int i = low, j = high;
		int pivot = arr[low + (high - low) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				exchange(arr, i, j);
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(arr, panel, ms, low, j);
		if (i < high)
			quickSort(arr, panel, ms, i, high);
	}

	private static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	
	
	public static void mergeSort(int[] arr, JPanel panel, int ms) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, panel, ms, tmp, 0, arr.length - 1);
		panel.repaint();
	}

	private static void mergeSort(int[] arr, JPanel panel, int ms, int[] tmp, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(arr, panel, ms, tmp, left, center);
			mergeSort(arr, panel, ms, tmp, center + 1, right);
			panel.repaint();
			sleep(ms);
			merge(arr, tmp, left, center + 1, right);
		}
	}

	private static void merge(int[] arr, int[] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right])
				tmp[k++] = arr[left++];
			else
				tmp[k++] = arr[right++];
		}

		while (left <= leftEnd)
			tmp[k++] = arr[left++];

		while (right <= rightEnd)
			tmp[k++] = arr[right++];

		for (int i = 0; i < num; i++, rightEnd--)
			arr[rightEnd] = tmp[rightEnd];
	}

	
	
	
	
	
	
	public static void bubbleSort(int[] arr, JPanel panel, int ms) {
		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				panel.repaint();
				sleep(ms);
				if (arr[j - 1] > arr[j]) {
					// swap the elements!
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

	}
	
	
	
	

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
