class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        int count=0;
        for(int i:nums) if(i==0) count++;
        vector<int> ans;
        for(int i=0;i<nums.size();i++){
            if(nums[i]) ans.push_back(nums[i]);
        }

        while(count-->0){
            ans.push_back(0);
        }
        return ans;
    }
};