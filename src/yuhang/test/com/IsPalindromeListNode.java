package yuhang.test.com;

import java.util.Stack;

public class IsPalindromeListNode {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);
        IsPalindromeListNode isPalindromeListNode = new IsPalindromeListNode();
        System.out.println(isPalindromeListNode.isPalindrome(node));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        while(true){
            int temp = slow.val;
            stack.push(temp);
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                stack.pop();
                break;
            }
            fast = fast.next;
            if(fast == null) break;
        }
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(slow.val == temp) slow = slow.next;
            else return false;
        }
        return true;
    }
}
