package stack.medium;

import javafx.util.Pair;
import utils.info.Question;

import java.util.Arrays;
import java.util.Stack;

@Question(url = "https://leetcode.com/problems/next-greater-node-in-linked-list/")
public class NextGreaterNodeInLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode runner = head;
        while (runner != null) { runner = runner.next; count++; }
        int[] answer = new int[count];
        Stack<Pair<Integer, Integer>> indexToNumStack = new Stack<>();

        count = 0;
        while (head != null) {
            while (!indexToNumStack.isEmpty() && indexToNumStack.peek().getValue() < head.val)
                answer[indexToNumStack.pop().getKey()] = head.val;
            indexToNumStack.push(new Pair<>(count++, head.val));
            head = head.next;
        }

        return answer;
    }

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList ngnill = new NextGreaterNodeInLinkedList();
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(5)));
        System.out.println(Arrays.toString(ngnill.nextLargerNodes(head)));
    }

}
