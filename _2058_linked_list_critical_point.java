//A critical point in a linked list is defined as either a local maxima or a local minima.
//
//A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
//
//A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
//
//Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
//
//Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].


public class _2058_linked_list_critical_point {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = Integer.MAX_VALUE, min_dist = Integer.MAX_VALUE;
        int last = 0;
        int prev = head.val;
        for(int i=0;head.next!=null;++i){
            if((prev < head.val && head.val > head.next.val) || (prev > head.val && head.val < head.next.val))
            {
                if(last!=0){
                    min_dist = Math.min(min_dist,i-last);
                }
                first = Math.min(first,i);
                last = i;
            }
            prev = head.val;
            head = head.next;
        }
        if(min_dist == Integer.MAX_VALUE){
            return new int[] {-1,-1};
        }
        return new int[] {min_dist,last-first};
    }
}
