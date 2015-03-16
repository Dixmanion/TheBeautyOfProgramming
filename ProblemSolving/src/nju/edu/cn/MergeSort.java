package nju.edu.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 将两个有序表合并成一个有序表
 * @author eureka
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public class Solution {
	    public List<String> findRepeatedDnaSequences(String s) {
	        List<String> repeated = new ArrayList<String>();
	        Set<String> repeatedSet = new HashSet<String>();
	        
	        if (s.length() <= 10) return null;
	        
	        for (int i = 0; i < s.length() - 10; i++) {
	            String tempSub = s.substring(i, i + 9);
	            String tempCon = s.substring(i+1, s.length() - 1);
	            if (stringContained(tempCon, tempSub)) {
	                repeatedSet.add(tempSub);
	            }
	        }
	        
	        repeated.addAll(repeatedSet);
	        
	        return repeated;
	    }
	    
	    private boolean stringContained(String container, String subString) {
	        return container.contains(subString);
	    }
	}
}
