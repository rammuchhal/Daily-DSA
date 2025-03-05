class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>> dp(n+1,vector<vector<int>>(2,vector<int>(k+1,0)));

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int t=1;t<=k;t++){
                    if(buy){
                        dp[i][1][t]=max(-prices[i]+dp[i+1][0][t],dp[i+1][1][t]);
                    }
                    else{
                        dp[i][0][t]=max(prices[i]+dp[i+1][1][t-1],dp[i+1][0][t]);
                    }  
                }
            }
        }
        return dp[0][1][k];
    }
};