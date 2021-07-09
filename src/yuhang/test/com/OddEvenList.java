package yuhang.test.com;

public class OddEvenList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        OddEvenList oddEvenList = new OddEvenList();
        ListNode res = oddEvenList.oddEvenList(root);
        while(res != null){
            System.out.print(res.val);
            res = res.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        int length = 1;
        ListNode even = head;
        ListNode odd = head.next;
        ListNode evenHead = head;
        ListNode oddHead = head;
        while(head != null && head.next != null){
            odd.next = head.next;
            even.next = odd.next.next;
            head = head.next.next;
        }
        even.next = odd.next;
        return evenHead;
    }
}
