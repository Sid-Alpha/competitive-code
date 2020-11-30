package interview.easy.linkedlist;

import utils.info.FoundDifficult;
import utils.info.UsedHints;
import utils.linkedlist.ListNode;

@FoundDifficult
@UsedHints
public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        if(head.next.next == null) return head.val == head.next.val;
        int oGCount = 0;
        ListNode runner = head;
        while(runner != null) {
            runner = runner.next;
            oGCount++;
        }
        System.out.println("COUNT: "+ oGCount);
        int mid = oGCount/2, count = 0;
        ListNode reverser = head, tail = null;
        runner = head.next;
        System.out.println("MID: "+ mid);

        while(count++ < mid) {
            reverser.next = tail;
            tail = reverser;
            reverser = runner;
            runner = runner.next;
        }
        ListNode rightListRunner = (oGCount % 2 == 0) ? reverser : reverser.next, leftListRunner = tail;
        System.out.println("LEFT: " + leftListRunner.val + " RIGHT: " + rightListRunner.val);

        while (rightListRunner != null && leftListRunner != null) {
            System.out.println("LR: " + leftListRunner + " RR: " + rightListRunner);
            if(rightListRunner.val != leftListRunner.val) return false;
            rightListRunner = rightListRunner.next;
            leftListRunner = leftListRunner.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
//        System.out.println(isPalindrome(head));
//
//        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(1)));
//        System.out.println(isPalindrome(head1));
//
//        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));
//        System.out.println(isPalindrome(head2));
//
//        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(5))));
//        System.out.println(isPalindrome(head3));

//        ListNode head4 = new ListNode(1, new ListNode(2));
//        System.out.println(isPalindrome(head4));

//        ListNode head5 = new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(1))));
//        System.out.println(isPalindrome(head5));

        ListNode head6 = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(isPalindrome(head6));


//        ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(1)))));
//        System.out.println(isPalindrome(head5));
    }
}
