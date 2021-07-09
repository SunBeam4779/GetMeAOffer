package yuhang.test.com;

import java.util.Stack;

public class RecordList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        RecordList recordList = new RecordList();
        recordList.reorderList(node);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tail = head;
        ListNode record = head;
        ListNode node;
        while(true){
            tail = tail.next.next;
            record = record.next;
            if(tail == null){
                node = record;
                break;
            }
            if(tail.next == null){
                node = record.next;
                break;
            }
        }
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        ListNode result = head;
        while(!stack.isEmpty()){
            ListNode temp = result.next;
            result.next = stack.pop();
            result.next.next = temp;
            result = result.next.next;
        }
        result.next = null;
    }
}
