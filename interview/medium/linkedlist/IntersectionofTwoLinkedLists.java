package interview.medium.linkedlist;

import utils.info.Question;
import utils.linkedlist.ListNode;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/")
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int l1 = computeLength(headA);
        int l2 = computeLength(headB);
        ListNode longerList = l1 > l2 ? headA : headB;
        ListNode shorterList = l1 > l2 ? headB : headA;
        int llL = l1 > l2 ? l1 : l2, slL = l1 > l2 ? l2 : l1;

        // cull longer list
        while(llL-- > slL) longerList = longerList.next;

        while(longerList != null) {
            if(longerList == shorterList) return longerList;
            longerList = longerList.next;
            shorterList = shorterList.next;
        }
        return null;
    }

    private int computeLength(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        IntersectionofTwoLinkedLists i2LL = new IntersectionofTwoLinkedLists();
        ListNode common1 = ListNode.generateList(8,4,5);
        ListNode head1 = ListNode.generateList(4,1); head1.next.next = common1;
        ListNode head2 = ListNode.generateList(5,0,1); head2.next.next.next = common1;

        System.out.println(i2LL.getIntersectionNode(head1, head2));
    }
}