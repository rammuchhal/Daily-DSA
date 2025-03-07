class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        int c=cuts.size();
        cuts.push_back(n);
        cuts.push_back(0);
        sort(cuts.begin(),cuts.end());
        vector<vector<int>> dp(c+2,vector<int>(c+2,0));

        for(int i=c;i>=1;i--){
            for(int j=i;j<=c;j++){
                if(i>j) continue;
                int mini=1e9;
                for(int id=i;id<=j;id++){
                    int cost= (cuts[j+1]-cuts[i-1]) + dp[i][id-1]+dp[id+1][j];
                    mini=min(mini,cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][c];
    }
};