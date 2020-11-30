package interview.easy.linkedlist;

import utils.linkedlist.ListNode;

import static utils.linkedlist.ListNode.entireListAsString;

public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 1;
        ListNode runner = head, nodeToDelete = head, prev = nodeToDelete;
        while(runner.next!=null) {
            runner=runner.next;
            counter++;
            if(counter - n > 0) {
                prev = nodeToDelete;
                nodeToDelete = nodeToDelete.next;
            }
        }
        if(nodeToDelete == head) return head.next;
        prev.next = nodeToDelete.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(entireListAsString(removeNthFromEnd(head, 2)));
    }
}
