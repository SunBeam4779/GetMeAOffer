package yuhang.test.com;


public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseList reverseList = new ReverseList();
        head = reverseList.reverseList(head);
        while (head != null){
            System.out.print(head.val + "-");
            head = head.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode tail = new ListNode(head.val);

        while(head.next != null){
            ListNode pre = new ListNode(head.next.val);
            pre.next = tail;
            tail = pre;
            head = head.next;
        }
        return tail;
    }
}
