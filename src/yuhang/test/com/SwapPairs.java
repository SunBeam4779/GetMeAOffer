package yuhang.test.com;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 0; i < 1; ++i){
            head.next = new ListNode(i + 2);
            head = head.next;
        }
        SwapPairs swapPairs = new SwapPairs();
        ListNode res = swapPairs.swapPairs(node);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode res = node;
        while(node.next.next != null){
            ListNode first = node.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            node.next = second;
            node = node.next.next;
            if(node.next == null) break;
        }
        return res.next;
    }
}
