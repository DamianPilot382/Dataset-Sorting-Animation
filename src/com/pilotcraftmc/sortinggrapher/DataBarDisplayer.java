package com.pilotcraftmc.sortinggrapher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.pilotcraftmc.sortinggrapher.sortingmethods.BogoSort;
import com.pilotcraftmc.sortinggrapher.sortingmethods.BozoSort;
import com.pilotcraftmc.sortinggrapher.sortingmethods.InsertionSort;
import com.pilotcraftmc.sortinggrapher.sortingmethods.MergeSort;
import com.pilotcraftmc.sortinggrapher.sortingmethods.QuickSort;
import com.pilotcraftmc.sortinggrapher.sortingmethods.SortingMethod;

/**
 * The {@code DataBarDisplayer} class handles the display of the array.
 * <p>
 * It is a subclass of {@code JPanel} and overrides {@code paintComponent} to draw directly onto the frame.
 * </p>
 * <p>
 * This class is <b>not</b> thread-safe and will throw an {@code InterruptedException} if interrupted.
 * </p>
 * 
 * @author Leon Montealegre
 * @author Damian Ugalde
 * @version 0.05
 */
public class DataBarDisplayer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final SortingMethod[] SORTING_METHODS = {new QuickSort(), new MergeSort(), new InsertionSort(), new BozoSort(), new BogoSort()};
	public static final Object[] SORTING_METHOD_NAMES;
	static {
		SORTING_METHOD_NAMES = new Object[SORTING_METHODS.length];
		for (int i = 0; i < SORTING_METHODS.length; i++)
			SORTING_METHOD_NAMES[i] = SORTING_METHODS[i].getName();
	}
	
	private final int width, height;
	private int[] arr;
	private int maxValue;
	private boolean rainbow;
	
	/**
	 * Constructs a {@code DataBarDisplayer} and initializes it with the given arguments.
	 * 
	 * @param 	width
	 * 				the width of the graph.
	 * 
	 * @param 	height
	 * 				the height of the graph.
	 * 
	 * @param 	arr
	 * 				the array of data.
	 * 
	 * @param 	rainbow
	 * 				boolean to specify if the data bars should be a rainbow.
	 */
	public DataBarDisplayer(int width, int height, int[] arr, boolean rainbow) {
		this.width = width;
		this.height = height;
		this.arr = arr;
		this.rainbow = rainbow;
		
		maxValue = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > maxValue)
				maxValue = i;
		}
		
		this.setSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
	}
	
	/**
	 * Sorts the data bars with the given sorting method index.
	 * 
	 * @param 	index
	 * 				the index of the sorting method.
	 * 
	 * @param 	ms
	 * 				the amount of time (in milliseconds) to pause between each iteration of the sort.
	 */
	public void sort(int index, int ms) {
		SORTING_METHODS[index].sort(this, ms, arr);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		final double BAR_WIDTH = (double)width / arr.length;
		final int SPACING = (BAR_WIDTH/2 >= 1 ? 1 : 0);
		for (int i = 0; i < arr.length; i++) {
			g2d.setColor(rainbow ? Color.getHSBColor((float)i/arr.length, 1, 1) : Color.WHITE);
			double y = (double)arr[i] * height / maxValue;
			g2d.fillRect(i*(int)BAR_WIDTH, (int)(height-y), (int)Math.max(BAR_WIDTH-SPACING, 1), (int)y);
		}
	}
	
}
