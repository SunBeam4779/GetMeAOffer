package yuhang.test.com;

import java.util.Stack;

public class DetectCircle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode enter = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = enter;
        DetectCircle detectCircle = new DetectCircle();
        ListNode res = detectCircle.detectCycle(head);
        System.out.println(res.val);
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null){
            if(quick.next == null){
                return null;
            }
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                ListNode ptr = head;
                while(ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
