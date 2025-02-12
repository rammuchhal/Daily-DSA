class Solution {
public:
    int getMoney(int idx,vector<int>& nums,vector<int>& dp){
        if(idx==0){
            return nums[idx];
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];

        int pick=nums[idx]+getMoney(idx-2,nums,dp);
        int notPick = 0+getMoney(idx-1,nums,dp);
        return dp[idx]=max(pick,notPick);
    }
    int rob(vector<int>& nums) {
        int idx = nums.size()-1;
        vector<int> dp(idx+1,-1);
        return getMoney(idx,nums,dp);
    }
};