package nju.edu.cn.leetcode;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 快慢指针
	 * @author eureka
	 *
	 */
	public class Solution {
		
		public boolean hasCycle(ListNode head) {
			if (head == null || head.next == null) return false;
			ListNode slower = head;
			ListNode faster = head;
			while (slower.next != null && faster.next != null && faster.next.next != null) {
				slower = slower.next;
				faster = faster.next.next;
				if (slower.equals(faster)) return true;
			}
	        
			return false;
	    }
		
		
	}

}
