package interview.medium.linkedlist;

import utils.info.Enhance;
import utils.info.Question;
import utils.linkedlist.ListNode;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/")
@Enhance(details = "Concise code, reduce time complexity")
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode head = null, pointer = null, runner, zeroNode = new ListNode(0);
        int carry = 0;
        while (l1 != null || l2 != null) {
            runner = new ListNode();
            if(l1 == null) l1 = zeroNode; else if(l2 == null) l2 = zeroNode;
            int val = l1.val + l2.val + carry;
            if(val > 9) carry = 1; else carry = 0;
            runner.val = val % 10;

            if(head == null) {
                head = runner;
                pointer = head;
            }
            else {
                pointer.next = runner;
                pointer = pointer.next;
            }

            l1 = l1.next; l2 = l2.next;
        }
        if(carry == 1) pointer.next = new ListNode(1);
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode n3 = new ListNode(1, new ListNode(8));
        ListNode n4 = new ListNode(0);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        System.out.println(ListNode.entireListAsString(addTwoNumbers.addTwoNumbers(n1, n2)));
        System.out.println(ListNode.entireListAsString(addTwoNumbers.addTwoNumbers(n3, n4)));
    }


}
