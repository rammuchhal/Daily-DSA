class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long long,vector<long long>,greater<long long>> pq;

        for(int num:nums)
            pq.push(num);
        
        int op=0;
        while(!pq.empty() && pq.top()<k){
            long long x=pq.top();
            pq.pop();
            long long y=pq.top();
            pq.pop();
            op++;
            long long val=min(x,y)*2 + max(x,y);
            pq.push(val);
        }
        return op;
    }
};