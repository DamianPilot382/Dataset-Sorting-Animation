package com.pilotcraftmc.datasetsortinganimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.pilotcraftmc.datasetsortinganimation.sortingmethods.*;

public class DataBarDisplayer extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final SortingMethod[] SORTING_METHODS = {new QuickSort(), new MergeSort(), new InsertionSort(), new BozoSort(), new BogoSort()};
	public static final Object[] SORTING_METHOD_NAMES;
	static {
		SORTING_METHOD_NAMES = new Object[SORTING_METHODS.length];
		for (int i = 0; i < SORTING_METHODS.length; i++)
			SORTING_METHOD_NAMES[i] = SORTING_METHODS[i].getName();
	}
	
	public final int width, height;
	public int[] arr;
	public int maxValue;
	private boolean rainbow;
	
	public DataBarDisplayer(int width, int height, int[] arr, boolean rainbow){
		this.width = width;
		this.height = height;
		this.arr = arr;
		this.rainbow = rainbow;
		
		maxValue = Integer.MIN_VALUE;
		for (int i : arr){
			if (i > maxValue)
				maxValue = i;
		}
		
		this.setSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		final double BAR_WIDTH = (double)width / arr.length;
		final int SPACING = (BAR_WIDTH/2 >= 1 ? 1 : 0);
		for (int i = 0; i < arr.length; i++){
			g2d.setColor(rainbow ? Color.getHSBColor((float)i/arr.length, 1, 1) : Color.WHITE);
			double y = (double)arr[i] * height / maxValue;
			g2d.fillRect(i*(int)BAR_WIDTH, (int)(height-y), (int)Math.max(BAR_WIDTH-SPACING, 1), (int)y);
		}
	}
	
	/**
	 * 
	 * @param index
	 * @param ms
	 */
	public void sort(int index, int ms) {
		SORTING_METHODS[index].sort(this, ms, arr);
	}
	
}
