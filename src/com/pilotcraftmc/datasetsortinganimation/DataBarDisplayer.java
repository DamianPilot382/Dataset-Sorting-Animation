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
	
	public DataBarDisplayer(int width, int height, int[] arr){
		this.width = width;
		this.height = height;
		this.arr = arr;
		
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
			g2d.setColor(getColorArray(arr.length)[i]);
			int y = (int)((double)arr[i]/maxValue*height);
			g2d.fillRect((int)((double)i*(BAR_WIDTH+SPACING)), height-y, BAR_WIDTH, y);
		}
	}
	
	public Color[] getColorArray(int x){
		Color[] arr = new Color[x];
		
		Color[] redToOrange = getColorArray(Color.RED, Color.ORANGE, x / 6);
		Color[] orangeToYellow = getColorArray(Color.ORANGE, Color.YELLOW, x / 6);
		Color[] yellowToGreen = getColorArray(Color.YELLOW, Color.GREEN, x / 6);
		Color[] greenToBlue = getColorArray(Color.GREEN, Color.BLUE, x / 6);
		Color[] blueToIndigo = getColorArray(Color.BLUE, new Color(75, 0, 30), x / 6);
		Color[] indigoToViolet = getColorArray(new Color(75, 0, 30), new Color(238, 130, 238), x / 6);
		
		System.arraycopy(redToOrange, 0, arr, 0, redToOrange.length);
		System.arraycopy(orangeToYellow, 0, arr, redToOrange.length, orangeToYellow.length);
		System.arraycopy(yellowToGreen, 0, arr, redToOrange.length + orangeToYellow.length, yellowToGreen.length);
		System.arraycopy(greenToBlue, 0, arr, redToOrange.length + orangeToYellow.length + yellowToGreen.length, greenToBlue.length);
		System.arraycopy(blueToIndigo, 0, arr, redToOrange.length + orangeToYellow.length + yellowToGreen.length + greenToBlue.length, blueToIndigo.length);
		System.arraycopy(indigoToViolet, 0, arr, redToOrange.length + orangeToYellow.length + yellowToGreen.length + greenToBlue.length + blueToIndigo.length, indigoToViolet.length);
		
		arr[arr.length - 1] = new Color(238, 130, 238);
		
		return arr;
	}
	
	public Color[] getColorArray(Color a, Color b, int x){
		Color[] arr = new Color[x];
		
		arr[0] = a;
		for(int i = 1; i < arr.length; i++){
			int red = (int)((double)b.getRed() / x * i);
			int green = (int)((double)b.getGreen() / x * i);
			int blue = (int)((double)b.getBlue() / x * i);
			
			arr[i] = new Color(red, green, blue);
		}
		
		return arr;
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
