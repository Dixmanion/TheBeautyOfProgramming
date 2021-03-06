package nju.edu.cn;

import java.util.Arrays;

/**
 * 将两个有序表合并成一个有序表
 * @author eureka
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] array = {3485, 0, -3, 16, 7, 54, -7854};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	//递归调用的方法
	public void mergeSort(int[] a, int start, int end) {
		//防御式编程
		if (a == null || a.length == 0 || a.length == 1) { return; }

		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(a, start, middle);
			mergeSort(a, middle + 1, end);
			merge(a, start, middle + 1, end);
		}
	}
	
	//将两个有序序列合并起来，可以参考两个有序链表的合并
	private void merge(int[] a, int startIndex, int midIndex, int endIndex) {
		int low = startIndex;
		int high = midIndex;
		int[] temp = new int[endIndex - startIndex + 1];
		int tempIndex = 0;
		
		while (low < midIndex && high <= endIndex) {
			if (a[high] < a[low]) {
				temp[tempIndex] = a[high];
				tempIndex++;
				high++;
			} else if (a[low] < a[high]){
				temp[tempIndex] = a[low];
				low++;
				tempIndex++;
			}
		}
		
		while (low < midIndex) {
			temp[tempIndex] = a[low];
			low++;
			tempIndex++;
		}
		
		while (high <= endIndex) {
			temp[tempIndex] = a[high];
			high++;
			tempIndex++;
			
		}
		
		System.arraycopy(temp, 0, a, startIndex, endIndex - startIndex + 1);
	}

//	public class Solution {
//	    public List<String> findRepeatedDnaSequences(String s) {
//	        List<String> repeated = new ArrayList<String>();
//	        Set<String> repeatedSet = new HashSet<String>();
//	        
//	        if (s.length() <= 10) return null;
//	        
//	        for (int i = 0; i < s.length() - 10; i++) {
//	            String tempSub = s.substring(i, i + 9);
//	            String tempCon = s.substring(i+1, s.length() - 1);
//	            if (stringContained(tempCon, tempSub)) {
//	                repeatedSet.add(tempSub);
//	            }
//	        }
//	        
//	        repeated.addAll(repeatedSet);
//	        
//	        return repeated;
//	    }
//	    
//	    private boolean stringContained(String container, String subString) {
//	        return container.contains(subString);
//	    }
//	}
}
