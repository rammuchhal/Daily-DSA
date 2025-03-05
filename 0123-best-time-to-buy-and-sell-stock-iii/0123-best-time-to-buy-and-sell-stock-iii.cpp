class Solution {
public:
    int getmaxProfit(int i,int buy,int tran,vector<int>& prices,int& n,vector<vector<vector<int>>>& dp){
        if(i==n) return 0;
        if(tran==0) return 0;

        if(dp[i][buy][tran]!=-1) return dp[i][buy][tran];
        if(buy){
            return dp[i][buy][tran]=max(-prices[i]+getmaxProfit(i+1,0,tran,prices,n,dp),getmaxProfit(i+1,1,tran,prices,n,dp));
        }
        return dp[i][buy][tran]=max(prices[i]+getmaxProfit(i+1,1,tran-1,prices,n,dp),getmaxProfit(i+1,0,tran,prices,n,dp));
    }
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>> dp(n,vector<vector<int>>(2,vector<int>(3,-1)));
        return getmaxProfit(0,1,2,prices,n,dp);
    }
};