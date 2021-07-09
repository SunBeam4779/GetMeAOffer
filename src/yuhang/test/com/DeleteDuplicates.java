package yuhang.test.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 2};
        ListNode head = new ListNode(values[0]);
        ListNode root = head;

        for(int i = 1; i < values.length; ++i){
            root.next = new ListNode(values[i]);
            root = root.next;
        }
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        var result = deleteDuplicates.deleteDuplicates(head);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head.next;
        int value = head.val;
        ListNode pre = head;
        while(start != null){
            if(start.val == value){
                start = start.next;
                pre.next = start;
            }
            else{
                value = start.val;
                start = start.next;
                pre = pre.next;
            }

        }
        return head;
    }
}
