package interview.medium.linkedlist;

import utils.info.Stat;
import utils.info.Enhance;
import utils.info.Question;
import utils.linkedlist.ListNode;

@Question(url = "https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/")
@Enhance(complexity = Stat.SPACE, details = "concise code")
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddNodes = head, evenNodes = head.next;
        ListNode oddRunner = oddNodes, evenRunner = evenNodes, runner = evenNodes.next;
        int negativeAs = -1;
        while(runner != null) {
            if(negativeAs < 0) {
                oddRunner.next = runner; oddRunner = oddRunner.next;
            }
            else {
                evenRunner.next = runner; evenRunner =runner;
            }
            runner = runner.next;
            negativeAs *= -1;
        }
        evenRunner.next = null;
        oddRunner.next = evenNodes;
        return oddNodes;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(ListNode.entireListAsString(oddEvenLinkedList.oddEvenList(n1)));
    }
}
