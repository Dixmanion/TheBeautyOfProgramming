package nju.edu.cn;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = {5478, -9, 0, -1, 0, 3, 3354, -434};
		HeapSort heapSort = new HeapSort();
		heapSort.buildMaxHeap(array);
		System.out.println(Arrays.toString(array));
		heapSort.heapSort(array);
		System.out.println(Arrays.toString(array));
	}

	
	public void heapSort(int[] array) {
		
		if (array == null || array.length == 0 || array.length == 1) { return; }
		
		for (int i = 0; i < array.length; i++) {
			//交换数据
			int max = array[0];
			array[0] = array[array.length - i - 1];
			array[array.length - i - 1] = max;
			//调整堆
//			System.out.println("i = " + i + Arrays.toString(array));
			adjustHeap(array, array.length - i - 1);
//			System.out.println("i = " + i + Arrays.toString(array));
		}
	}
	private void adjustHeap(int[] array, int length) {
		
		for (int i = (length/2 - 1); i >= 0; i--) {
			//与左子树相比
			if (array[i*2] > array[i]) {
				int node = array[i];
				array[i] = array[i*2];
				array[i*2] = node;
			}
			//与右子树相比
			if (i*2+1 <length && array[i*2+1] > array[i]) {
				int node = array[i];
				array[i] = array[i*2+1];
				array[i*2+1] = node;
			}
		}
	}
	
	private void buildMaxHeap(int[] array) {
		for (int i = 1; i < array.length; i++) {
			adjustHeap(array, i+1);
		}
	}
}
