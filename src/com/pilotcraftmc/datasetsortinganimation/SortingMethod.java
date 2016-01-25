package com.pilotcraftmc.datasetsortinganimation;

import java.awt.List;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}
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

	public static void insertionSort(int arr[], JPanel panel, int ms) {
		int n = arr.length;
		for (int j = 1; j < n; j++) {
			int key = arr[j];
			int i = j - 1;
			while ((i > -1) && (arr[i] > key)) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
			panel.repaint();
			sleep(ms);
		}
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}

	public static int[] bozoSort(int[] arr, JPanel panel, int ms) {
		while (!isSorted(arr)) {
			int i1 = (int) (Math.random() * arr.length);
			int i2 = (int) (Math.random() * arr.length);
			while (i1 == i2)
				i2 = (int) (Math.random() * arr.length);

			int temp = arr[i1];
			arr[i1] = arr[i2];
			arr[i2] = temp;

			panel.repaint();
			sleep(ms);
		}
			return arr;
	}
	
	public static int[] bogoSort(int[] arr, JPanel panel, int ms){
		while(!isSorted(arr)){
			ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
			for(int s : arr){
				list.add(s);
			}
			Collections.shuffle(list);
			for(int i = 0; i < arr.length; i++){
				arr[i] = list.get(i);
			}
			panel.repaint();
			sleep(ms);
		}
		
			return arr;
	}

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
