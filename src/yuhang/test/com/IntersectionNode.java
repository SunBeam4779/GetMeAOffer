package yuhang.test.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class IntersectionNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        a.next = new ListNode(1);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        b.next.next.next = a.next.next;
        IntersectionNode intersectionNode = new IntersectionNode();

        ListNode res = intersectionNode.getIntersectionNode(a, b);
        System.out.println(res.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null) return null;
//        int countA = 1;
//        int countB = 1;
//        ListNode tempA = headA;
//        ListNode tempB = headB;
//        while(tempA.next != null){
//            countA++;
//            tempA = tempA.next;
//        }
//        while(tempB.next != null){
//            countB++;
//            tempB = tempB.next;
//        }
//        if(tempA.val != tempB.val) return null;
//        if(countA > countB){
//            while(countA > countB){
//                headA = headA.next;
//                countA--;
//            }
//        }
//        if(countB > countA){
//            while(countB > countA){
//                headB = headB.next;
//                countB--;
//            }
//        }
//        while(headA != null && headB != null){
//            if(headA.next == headB.next) break;
//            headA = headA.next;
//            headB = headB.next;
//        }
//        headB = headB.next;
//        return headB;
        if(headA == null || headB == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA.next != null || tempB.next != null){
            if(tempA == tempB) return tempA;
            if(tempA.next == null) tempA = headB;
            if(tempB.next == null) tempB = headA;
            tempB = tempB.next;
            tempA = tempA.next;
        }

        return null;
    }
}
