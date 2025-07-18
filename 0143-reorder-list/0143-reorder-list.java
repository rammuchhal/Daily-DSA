/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head1=head;
        ListNode head2=slow.next;
        slow.next=null;

        ListNode prev=null,curr=head2;
        while(curr!=null){
            ListNode frwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=frwd;
        }

        head2=prev;

        while(head1!=null && head2!=null){
            ListNode frwd1=head1.next;
            head1.next=head2;
            head1=frwd1;

            ListNode frwd2=head2.next;
            head2.next=head1;
            head2=frwd2;
        }
    }
}