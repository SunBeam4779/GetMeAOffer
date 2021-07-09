package yuhang.test.com;

import java.util.Stack;

public class SortList {
    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        stack.peek();
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        SortList sortList = new SortList();
        head = sortList.sortList(head);
        while (head != null){
            System.out.print(head.val + "-");
            head = head.next;
        }
        String s = "AABB";

    }
    public ListNode sortList(ListNode head) {
        if(head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.next == null) break;
        }
        ListNode temp = slow.next;
        slow.next = null;
        head = sortList(head);
        temp = sortList(temp);
        head = merge(head, temp);
        return head;
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left != null || right != null){
            if(left != null && right != null) {
                if (left.val <= right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
            }else{
                if(left == null) {
                    h.next = right;
                    right = right.next;
                }
                else{
                    h.next = left;
                    left = left.next;
                }
            }
            h = h.next;
        }
        return res.next;
    }
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            min.push(x);
        }else{
            stack.push(x);
            if(x <= min.peek())
                min.push(x);
        }
    }

    public void pop() {
        if(stack.peek().equals(min.peek())){
            stack.pop();
            min.pop();
        }else
            stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}