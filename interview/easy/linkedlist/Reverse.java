package interview.easy.linkedlist;

import utils.info.FoundDifficult;
import utils.linkedlist.ListNode;

@FoundDifficult
public class Reverse {

    private static ListNode reverseLinkedList(ListNode node) {
//        if(node == null || node.next == null) return node;
//        ListNode head = reverseLinkedList(node.next);
//        node.next.next = node;
//        node.next = null;
//        return head;
        ListNode newHead = getReversedHead(node);
        reverseNodes(node);
        return newHead;
    }

    private static ListNode getReversedHead(ListNode node) {
        if(node == null || node.next == null) return node;
        return getReversedHead(node.next);
    }

    private static void reverseNodes(ListNode node) {
        if(node == null || node.next == null) return;
        reverseNodes(node.next);
        node.next.next = node;
        node.next = null;
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(ListNode.entireListAsString(list1));
        System.out.println(ListNode.entireListAsString(reverseLinkedList(list1)));


        ListNode list2 = null;
        System.out.println(ListNode.entireListAsString(reverseLinkedList(list2)));

        ListNode list3 = new ListNode(1);
        System.out.println(ListNode.entireListAsString(reverseLinkedList(list3)));

        ListNode list4 = new ListNode(1, new ListNode(2));
        System.out.println(ListNode.entireListAsString(reverseLinkedList(list4)));
    }
}
