package nju.edu.cn.leetcode;


public class LinkedListCycleII {

	public static void main(String[] args) {
		LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
		ListNode head = linkedListCycleII.new ListNode(3);
		ListNode second = linkedListCycleII.new ListNode(2);
		ListNode third = linkedListCycleII.new ListNode(0);
		ListNode forth = linkedListCycleII.new ListNode(-4);
		
		head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = head;
		
		System.out.println(linkedListCycleII.detectCycle(head).val);
		
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
	 * 也是用快慢指针
	 * 快慢指针找到的点所在环中的位置到head的距离，即loopSize
	 * 故，重新让faster从head开始走，
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
        ListNode faster = head;
        ListNode slower = head;
        
        while(faster.next != null && faster.next.next != null && slower.next != null) {
        	faster = faster.next.next;
        	slower = slower.next;
        	if (faster.equals(slower)) {
        		faster = head;
            	while (faster != slower) {
            		faster = faster.next;
            		slower = slower.next;
            	}
            	return slower;
        	}
        }
        
        return null;
    }

}
