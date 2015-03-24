package nju.edu.cn;

import java.util.Arrays;

public class BubbleSort {
	
	/**
	 * 递归版本
	 * @param array
	 * @param length
	 */
	public void bubbleSort(int[] array, int length){
		if (length <= 1) { return; }
		
		//此处length一定从2开始
		for (int i = 0; i < length - 1; i++) {
			if (array[i] > array[i+1]) {//如果前一个数比后一个数大，则交换
				int temp = array[i+1];
				array[i+1] = array[i];
				array[i] = temp;
			}
		}
		
		bubbleSort(array, length-1);
	}
	
	public static void main(String[] args) {
		int[] array = {7854, 332, -785, 0, 8, 23,-1445};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(array, array.length);
		System.out.println(Arrays.toString(array));
	}

}
