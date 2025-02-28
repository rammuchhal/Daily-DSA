class Solution {
public:
    bool getPartition(vector<int>& nums,int i,int target,vector<vector<int>>& dp){
        if(target==0) return true;
        if(i==0) return target==nums[0];

        if(dp[i][target]!=-1) return dp[i][target];
        bool notTake=getPartition(nums,i-1,target,dp);
        bool take=false;
        if(target>=nums[i]) take=getPartition(nums,i-1,target-nums[i],dp);

        return dp[i][target]=take|notTake;
    }
    bool canPartition(vector<int>& nums) {
        int n=nums.size();
        int totalSum=0;
        for(int i=0;i<n;i++) totalSum+=nums[i];

        if(totalSum%2) return false;
        int target=totalSum/2;
        vector<vector<int>> dp(n,vector<int>(target+1,-1));
        return getPartition(nums,n-1,target,dp);
    }
};