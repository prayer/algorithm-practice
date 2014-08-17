package com.practice.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = null;
		ListNode curr = null;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) { // consider the 2 integers have different length
			int digit = 0;
			if (l1 != null) digit += l1.val;
			if (l2 != null) digit += l2.val;
			digit = digit + carry;
			carry = digit / 10;
			digit = digit % 10;

			if (curr == null) {
				curr = new ListNode(digit);
				l3 = curr;
			} else {
				curr.next = new ListNode(digit);
				curr = curr.next;
			}

			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null : l2.next;
		}
		return l3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
