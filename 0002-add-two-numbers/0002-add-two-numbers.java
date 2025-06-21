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
        ListNode getReverse(ListNode head){
            ListNode prev=null;
            ListNode curr=head;

            while(curr!=null){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next; 
            }
            return prev;
        }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=l1;
        ListNode head2=l2;

        ListNode h1=head1,h2=head2;
        ListNode prev=null;

        int carry=0;
        while(h1!=null && h2!=null){
            int sum=h1.val+h2.val+carry;
            carry=sum/10;
            sum=sum%10;
            h2.val=sum;
            h1=h1.next;
            if(h2.next==null) prev=h2;
            h2=h2.next;
        }
        while(h2!=null){
            int sum=h2.val+carry;
            carry=sum/10;
            sum=sum%10;
            h2.val=sum;
            h2=h2.next;
        }
        boolean done=false;
        while(h1!=null){
            if(!done){
                prev.next=h1;
                done=true;
            }
            int sum=h1.val+carry;
            carry=sum/10;
            sum=sum%10;
            h1.val=sum;
            h1=h1.next;
        }
        ListNode newNode=null;
        if(carry!=0) newNode=new ListNode(carry);
        if(newNode==null) return head2;

        ListNode temp=head2;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head2;
    }
}