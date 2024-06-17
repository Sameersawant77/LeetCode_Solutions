//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.

public class _876_Middle_of_Linkedlist {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
