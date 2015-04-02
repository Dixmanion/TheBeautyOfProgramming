package nju.edu.cn.leetcode;

public class LinkedListReverse {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		
		if (head.next != null && head.next.next == null) {
			ListNode nextNode = head.next;
			nextNode.next = head;
			return nextNode;
		}
		
		ListNode prev = head;
		ListNode node = head.next;
		ListNode latter = head.next.next;
		
		while (latter != null) {
			node.next = prev;
			prev = node;
			node = latter;
			latter = latter.next;
		}
		
		node.next = prev;
		head.next = null;
		return node;
	}

}
