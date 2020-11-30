package interview.easy.linkedlist;

import utils.linkedlist.ListNode;

public class Deletenode {

    public void deleteNode(ListNode node) {
        ListNode prev = node, elm = node, next;
        while(null != elm.next) {
            next = elm.next;
            elm.val = next.val;
            prev = elm;
            elm = next;
        }
        prev.next = null;
    }

}
