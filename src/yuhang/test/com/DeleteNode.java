package yuhang.test.com;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        head = new DeleteNode().deleteNode(head, 5);
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = head;

        while(temp.next != null && temp.next.val != val){
            temp = temp.next;
        }
//        ListNode pre = temp;
        temp.next = temp.next.next;
//        pre.next = temp;
        return head;
    }
}
