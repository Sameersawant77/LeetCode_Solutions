import java.util.HashSet;

//You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

public class _3217_delete_duplicated_in_linked_list {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr.next != null){
            if(set.contains(curr.next.val)){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
