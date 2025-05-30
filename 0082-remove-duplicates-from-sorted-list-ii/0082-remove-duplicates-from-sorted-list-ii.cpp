/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* dummy = new ListNode(-101,head);
        ListNode* prev = dummy;
        ListNode* curr = head;

        while(curr!=NULL){
            ListNode* nextNode = curr->next;
            while(  (nextNode!=NULL) && (curr->val==nextNode->val)){
                ListNode* temp = nextNode->next;
                delete nextNode;
                nextNode = temp;
            }

            if(curr->next == nextNode){
                prev = curr;
            }
            else{
                prev->next = nextNode;
                delete curr;
            }

            curr = nextNode;
        }
        return dummy->next;
    }
};