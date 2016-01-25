package com.pilotcraftmc.datasetsortinganimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DataBarDisplayer extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int SPACING = 2;
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
		
		final int BAR_WIDTH = (int)((double)width / arr.length) - SPACING;
		for (int i = 0; i < arr.length; i++){
			if(rainbow){
				g2d.setColor(Color.getHSBColor((float)i/arr.length, 1, 1));//colorArray[i]);
			}else{
				g2d.setColor(Color.WHITE);
			}
			int y = (int)((double)arr[i]/maxValue*height);
			g2d.fillRect((int)((double)i*(BAR_WIDTH+SPACING)), height-y, BAR_WIDTH, y);
		}
	}
	
	/**
	 * 
	 * @param ms milliseconds between updates
	 */
	public void quickSort(int ms){
		SortingMethod.quickSort(arr, this, ms);
	}
	
	/**
	 * 
	 * @param ms milliseconds between updates
	 */
	public void mergeSort(int ms){
		SortingMethod.mergeSort(arr, this, ms);
	}
	
	/**
	 * 
	 * @param ms milliseconds between updates
	 */
	public void bubbleSort(int ms){
		SortingMethod.bubbleSort(arr, this, ms);
	}
	
	/**
	 * 
	 * @param ms milliseconds between updates
	 */
	public void insertionSort(int ms){
		SortingMethod.insertionSort(arr,this, ms);
	}
	
	public void bozoSort(int ms){
		SortingMethod.bozoSort(arr, this, ms);
	}
	
	public void bogoSort(int ms){
		SortingMethod.bogoSort(arr, this, ms);
	}
	
}
