package nju.edu.cn;

import java.util.Arrays;

public class InsertionSort {
	
	/**
	 * 循环版本
	 * @param array
	 */
	public void insertionSort(int[] array) {
		if (array == null || array.length == 0 || array.length == 1) { return; }
		
		for (int i = 1; i < array.length; i++) {
			
			if (array[i] < array[i-1]) {
				
				int numToInsert = array[i];
				int j;
				//寻找合适的位置插入
				for (j = i-1; j >= 0 && numToInsert < array[j]; j--) {
					array[j+1] = array[j];
				}
				array[j+1] = numToInsert;
			}
			
		}
	}
	/**
	 * 
	 * @param array
	 * @param start
	 */
	public void insertionSort(int[] array, int start) {
		if (array == null || array.length == 0 || array.length == 1) { return; }
		
		for (int i = 0; i < array.length; i++) {
			
		}
	}

	public static void main(String[] args) {
		int[] array = {0, -8343, -1, -1, 3, 3343, 44};
		InsertionSort sort = new InsertionSort();
		sort.insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
