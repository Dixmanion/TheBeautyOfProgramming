package nju.edu.cn;

import java.util.Arrays;

public class SelectionSort {

	/**
	 * 循环版本
	 * @param array
	 */
	public void selectionSort(int[] array) {
		
		//防御式编程
		if (array == null || array.length == 0) { return; }
		
		for (int i = 0; i < array.length - 1; i++) {
			
			int min = array[i];
			int minIndex = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
			
		}
	}
	
	/**
	 * 递归版本
	 * @param array
	 * @param start
	 */
	public void selectinSort(int[] array, int start) {
		
		//防御式编程
		if (array == null || array.length == 0 || array.length == 1) { return; }
		
		//递归终止条件
		if (start == array.length - 1) { return; }
		
		int min = array[start];
		int minIndex = start;
		
		for (int i = start; i < array.length; i++) {	
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		
		if (minIndex != start) {
			array[minIndex] = array[start];
			array[start] = min;
		}
		
		selectinSort(array, start+1);
	}
	
	public static void main(String[] args) {
		int[] array = {-4758, 32, 0 ,-1, -1, 438, 34, 6};
		SelectionSort selectionSort = new SelectionSort();
		//selectionSort.selectionSort(array);
		selectionSort.selectinSort(array, 0);
		System.out.println(Arrays.toString(array));
	}

}
