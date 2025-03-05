class Solution {
public:
    int getmaxProfit(int i,int buy,int k,int& n,vector<int>& prices,vector<vector<vector<int>>>& dp){
        //base
        if(i==n || k==0) return 0;

        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
        if(buy){
            return dp[i][1][k]=max(-prices[i]+getmaxProfit(i+1,0,k,n,prices,dp),getmaxProfit(i+1,1,k,n,prices,dp));
        }
        return dp[i][0][k]=max(prices[i]+getmaxProfit(i+1,1,k-1,n,prices,dp),getmaxProfit(i+1,0,k,n,prices,dp));
    }
    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>> dp(n,vector<vector<int>>(2,vector<int>(k+1,-1)));
        return getmaxProfit(0,1,k,n,prices,dp);
    }
};