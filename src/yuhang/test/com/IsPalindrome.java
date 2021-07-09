package yuhang.test.com;

import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        root.next = new ListNode(1);
//        root.next.next = new ListNode(0);
        System.out.println(new IsPalindrome().isPalindrome(root));
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode quick = head;
        ListNode ptr = null;
        while(quick != null){
            if(quick.next == null) {
                ptr = head.next;
                break;
            }
            stack.push(head.val);
            head = head.next;
            ptr = head;
            quick = quick.next.next;
        }

        while(!stack.isEmpty()){
            int val = stack.peek();
            if(ptr.val != val) return false;
            stack.pop();
            ptr = ptr.next;
        }
        return true;
    }
}
