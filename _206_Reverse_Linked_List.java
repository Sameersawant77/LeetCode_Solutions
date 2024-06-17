
//Given the head of a singly linked list, reverse the list, and return the reversed list.
public class _206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}


