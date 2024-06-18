//Given the head of a linked list, remove the nth node from the end of the list and return its head.

public class _19_remove_nth_node_linkedlist {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n;i++) fast = fast.next;
        if(fast==null) return head.next; // if n = size of linked list, remove first node (edge case)
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
