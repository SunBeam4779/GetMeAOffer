package yuhang.test.com;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNode res = mergeTwoLists.mergeTwoLists(l1, l2);
        while (res != null){
            System.out.print(res.val + "-");
            res = res.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            if(l2 == null)
                return null;
            else return l2;
        }else{
            if(l2 == null) return l1;
        }
        ListNode head;
        ListNode base;

        if(l2.val < l1.val) {
            head = l2;
            base = l1;
        }
        else {
            head = l1;
            base = l2;
        }
        ListNode res = head;
        while(head.next != null){
            int cmp = head.next.val;
            if(base != null && base.val <= cmp){
                ListNode temp = new ListNode(base.val);
                ListNode tail = head.next;
                head.next = temp;
                temp.next = tail;
                base = base.next;
            }else{
                head = head.next;
            }
        }
        head.next = base;
        return res;

    }
}
