class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> dp(n,0);

        for(int i=0;i<m;i++){
            vector<int> curr(n,0);
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[0]=1;
                else{
                    int up=0,left=0;
                    if(i>0) up=dp[j];
                    if(j>0) left=curr[j-1];
                    curr[j]=up+left;
                }
            }
            dp=curr;
        }
        return dp[n-1];
    }
};