package yuhang.test.com;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        InsertionSortList insertionSortList = new InsertionSortList();
        var res = insertionSortList.insertionSortList(root);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {

        ListNode rest = head.next;
        ListNode sorted = head;
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        while(rest != null){
            if(sorted.val <= rest.val){
                sorted = sorted.next;
            }else{
                ListNode before = pre;
                while(before.next.val <= rest.val){
                    before = before.next;
                }
                sorted.next = rest.next;
                rest.next = before.next;
                before.next = rest;
            }
            rest = sorted.next;
        }
        return pre.next;
    }
}
