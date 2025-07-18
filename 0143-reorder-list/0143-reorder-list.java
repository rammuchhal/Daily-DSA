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
    public ListNode pushToStack(ListNode head,int start,int end,Stack<ListNode> stk){
        for(int i=start;i<end;i++){
            stk.push(head);
            ListNode frwd=head.next;
            head.next=null;
            head=frwd;
        }
        return head;
    }
    public ListNode addToLL(Stack<ListNode> stk,ListNode tail){
        while(!stk.isEmpty()){
            ListNode node=stk.peek();
            stk.pop();
            tail.next=node;
            tail=node;
        }
        return tail;
    }
    public void reorderList(ListNode head) {

        if(head==null || head.next==null) return;

        Stack<ListNode> stk=new Stack<>();

        int length=getLength(head);

        head=pushToStack(head,0,length/2,stk);

        ListNode tail=getTailNode(head);

        tail=addToLL(stk,tail);

        head=pushToStack(head,length/2,length,stk);
        
        tail=addToLL(stk,tail);
        
        head=pushToStack(head,0,length/2,stk);

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