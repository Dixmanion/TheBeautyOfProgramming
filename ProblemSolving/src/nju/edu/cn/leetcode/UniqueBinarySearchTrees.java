package nju.edu.cn.leetcode;

import java.util.Arrays;
/**
 * 利用DP完成
 * 优化：对称性
 * @author eureka
 *
 */
public class UniqueBinarySearchTrees {
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
		System.out.println(uniqueBinarySearchTrees.numTrees(5));
	}
	
	
	int[] numTrees;
	
	public int numTrees(int n) {
		if (n == 0 || n == 1) return 1;
		if (n == 2) return 2;
		numTrees = new int[n+1];//DP
		Arrays.fill(numTrees, -1);
		numTrees[0] = 1;
		numTrees[1] = 1;
		numTrees[2] = 2;
		
        return BSTNums(n);
    }
	
	private int BSTNums(int length) {
		int result = 0;
		
		if (numTrees[length] != -1) return numTrees[length];
		
		for (int i = 0; i < length/2; i++) {
			//左子树的可能性
			int leftNum = BSTNums(i);
			//右子树的可能性
			int rightNum = BSTNums(length-1-i);
			//相乘
			result = leftNum*rightNum + result;
		}
		result = result + result;
		if (length % 2 != 0) {
			int num = BSTNums(length/2);
			result = result + num*num;
		}
		if (numTrees[length] == 0) numTrees[length] = result;
		return result;
	}
	
}
