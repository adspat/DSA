/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        int ans = 0 ;
        while(fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
            if(slow == fast){
                slow = head ;
                while(slow != fast){
                    slow = slow.next ;
                    fast = fast.next;
                    ans ++ ;
                }
                return slow ;
            }
        }
        return null ;
    }
}