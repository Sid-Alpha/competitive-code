package utils.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) { val = x; }
    public ListNode(int x, ListNode next) { this.val = x; this.next = next; }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public static ListNode generateList(int ... numbers) {
        ListNode head = null, runner = head;
        for(int num : numbers) {
            ListNode newNode = new ListNode(num);
            if(head == null) { head = newNode; runner = newNode; }
            else { runner.next = newNode; runner = runner.next; }
        }
        return head;
    }

    public static String entireListAsString(ListNode node) {
        if(node == null) return "";
        return node.val + ((node.next != null) ? " -> " + entireListAsString(node.next) : "") ;
    }
}
