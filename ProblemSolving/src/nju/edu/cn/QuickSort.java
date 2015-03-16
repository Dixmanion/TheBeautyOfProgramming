package nju.edu.cn;
/**
 * 快速排序
 * 利用数组第一个元素，将数组划分为比该元素大的部分，和比该元素小的部分
 * 分别对两部分进行快排
 * 当low>=high时，return
 * @author eureka
 *
 */
public class QuickSort {
	
	public static void quickSort(int[] array, int low, int high){
		
		//特殊情况
		if (low >= high) return;
		
		//递归
		int compare = array[low];
		int l = low;
		int h = high;
		
		while (l < h) {
			
			while (l < h && array[h] > compare) h--;
			array[l] = array[h];
			
			while (l < h && array[l] < compare) l++;
			array[h] = array[l];
		}
		array[l] = compare;
		quickSort(array, low, l);
		quickSort(array, l+1, high);
	}

	public static void main(String[] args) {
		int[] array = {-9, 567, 3, 0, 46, 234};
		QuickSort.quickSort(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
