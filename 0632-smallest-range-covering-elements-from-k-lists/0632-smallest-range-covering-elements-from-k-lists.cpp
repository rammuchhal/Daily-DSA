class node{
    public:
        int data;
        int row;
        int col;
        node(int data,int row,int col){
            this->data = data;
            this->row = row;
            this->col = col;
        }
};
class compare{
    public:
    bool operator()(node* a,node* b){
        return a->data>b->data;
    }
};
class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        int k = nums.size();

        int maxi=INT_MIN;
        int mini = INT_MAX;
        
    
        priority_queue<node*,vector<node*>,compare> minHeap;
        
        for(int i=0;i<k;i++){
            int element = nums[i][0];
            maxi=max(maxi,element);
            mini = min(mini,element);
            minHeap.push(new node(element,i,0));
        }
        
        int start = mini;
        int end = maxi;
        
        while(!minHeap.empty()){
            node* temp = minHeap.top();
            minHeap.pop();
            
            mini = temp->data;
            if( (maxi-mini)<(end-start) ){
                start = mini;
                end = maxi;
            }
            if(temp->col+1<nums[temp->row].size()){
                maxi = max(maxi,nums[temp->row][temp->col+1]);
                minHeap.push(new node(nums[temp->row][temp->col+1],temp->row,temp->col+1));
            }
            else break;
            
        }
        return {start,end};
    }
};