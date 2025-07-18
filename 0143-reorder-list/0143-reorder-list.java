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
    public int getLength(ListNode head){
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    public ListNode getTailNode(ListNode head){
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    public void reorderList(ListNode head) {

        if(head==null || head.next==null) return;
        
        Stack<ListNode> stk=new Stack<>();

        int length=getLength(head);

        for(int i=0;i<length/2;i++){
            stk.push(head);
            head=head.next;
        }

        ListNode tail=getTailNode(head);

        while(!stk.isEmpty()){
            ListNode node=stk.peek();
            stk.pop();
            tail.next=node;
            tail=node;
        }
        for(int i=length/2;i<length;i++){
            stk.push(head);
            head=head.next;
        }
        while(!stk.isEmpty()){
            ListNode node=stk.peek();
            stk.pop();
            tail.next=node;
            tail=node;
        }
        for(int i=0;i<length/2;i++){
            stk.push(head);
            head=head.next;
        }
        while(!stk.isEmpty()){
            ListNode node=stk.peek();
            stk.pop();
            tail.next=node;
            tail=node;
            tail.next=head;
            tail=head;
            ListNode forw=head.next;
            head.next=null;
            head=forw;
        }
        if(length%2!=0){
            ListNode frwd=head.next;
            tail.next=head;
            head.next=null;
            head=frwd;
        }
    }
}