package nju.edu.cn;

import java.util.Arrays;

public class ShellSort {

	/**
	 * 递归版本
	 * @param a, 待排序数组
	 * @param d, 增量值
	 */
	public void shellSort(int[] a, int d) {
		
		if (a== null || a.length == 0 || a.length == 1) { return; }
		
		for (int i = d; i < a.length; i++) {
			int numToInsert = a[i];
			int j;
			for (j = i - d; j >= 0 && a[j] > numToInsert; j-=d) {
				a[j+d] = a[j];
			}
			a[j+d] = numToInsert;
		}
		if (d != 1) {
			shellSort(a, d/2);
		}
	}
	/**
	 * 循环版本
	 * @param array
	 */
	public void shellSort(int[] array) {
		
		if (array == null || array.length == 0 || array.length == 1) { return; }
		
		//遍历增量值
		for (int d = array.length/2; d >= 1; d=d/2) {
			//从i=d开始，此处开始为插入排序
			for (int i = d; i < array.length; i++) {
				int numToInsert = array[i];
				int j;
				for (j = i - d; j >= 0 && array[j] > numToInsert; j-=d) {
					array[j+d] = array[j];
				}
				array[j+d] = numToInsert;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5435, -854, 0, 43, -6732, 34, -1, -1, 0};
		ShellSort shellSort = new ShellSort();
		//shellSort.shellSort(array, array.length/2);
		shellSort.shellSort(array);
		System.out.println(Arrays.toString(array));
	}

}
