package com.pilotcraftmc.datasetsortinganimation.sortingmethods;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class BogoSort extends SortingMethod {

	@Override
	public void sort(JPanel panel, int ms, int[] arr){
		while(!isSorted(arr)){
			ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
			for (int s : arr)
				list.add(s);
			Collections.shuffle(list);
			for(int i = 0; i < arr.length; i++)
				arr[i] = list.get(i);
			repaintAndSleep(panel, ms);
		}
	}

}
