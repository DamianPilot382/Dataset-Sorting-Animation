package com.pilotcraftmc.sortinggrapher.sortingmethods;

import javax.swing.JPanel;

public class ShellSort extends SortingMethod {
	
      public void sort(JPanel panel, int ms, int[] data) {
        int inner, outer;
        int temp;
        //find initial value of h
        int h = 1;
        while (h <= data.length / 3)
          h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)

        while (h > 0) // decreasing h, until h=1
        {
          // h-sort the file
          for (outer = h; outer < data.length; outer++) {
            temp = data[outer];
            repaintAndSleep(panel, ms);
            inner = outer;
            // one subpass (eg 0, 4, 8)
            while (inner > h - 1 && data[inner - h] >= temp) {
              data[inner] = data[inner - h];
              repaintAndSleep(panel, ms);
              inner -= h;
            }
            data[inner] = temp;
            repaintAndSleep(panel, ms);
          }
          h = (h - 1) / 3; // decrease h
        }
      }

}
