class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n=nums.size();
        nums.push_back(1);
        nums.insert(nums.begin(),1);
        vector<vector<int>> dp(n+2,vector<int>(n+2,0));

        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;

                int maxi=INT_MIN;
                for(int id=i;id<=j;id++){
                    int cost=nums[i-1]*nums[id]*nums[j+1] + dp[i][id-1] + dp[id+1][j];
                    maxi=max(maxi,cost);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][n];
    }
};