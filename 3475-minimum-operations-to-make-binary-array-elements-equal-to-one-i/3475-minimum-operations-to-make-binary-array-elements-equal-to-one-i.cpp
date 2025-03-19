class Solution {
public:
    int minOperations(vector<int>& nums) {
        int op = 0;
        int n = nums.size();
        
        for(int i=0;i<=(n-3);i++){
            if(nums[i]!=1){
                nums[i] = nums[i]^1;
                nums[i+1] = nums[i+1]^1;
                nums[i+2] = nums[i+2]^1;
                op++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]!=1) return -1;
        }
        return op;
    }
};