package com.pilotcraftmc.sortinggrapher.sortingmethods;

import javax.swing.JPanel;

public class RadixSort extends SortingMethod{

	@Override
	public void sort(JPanel panel, int ms, int[] a) {
		int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[a.length];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
                //repaintAndSleep(panel, ms);
            }
            for (i = n - 1; i >= 0; i--){
                b[--bucket[(a[i] / exp) % 10]] = a[i];
                //repaintAndSleep(panel, ms);
            }
            for (i = 0; i < n; i++){
                a[i] = b[i];
                repaintAndSleep(panel, ms);
            }
            exp *= 10;        
        }
	}  
	
}
