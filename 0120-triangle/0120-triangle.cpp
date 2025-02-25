class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        int ans=INT_MAX;
        vector<int> dp(n,0);
        dp[0]=triangle[0][0];

        for(int i=1;i<n;i++){
            vector<int> curr(n,0);
            for(int j=0;j<=i;j++){
                int path1=INT_MAX;
                if(i-1>=j) path1=triangle[i][j]+dp[j];

                int path2=INT_MAX;
                if(i>=j && j>0) path2=triangle[i][j]+dp[j-1];
                curr[j]=min(path1,path2);
            }
            dp=curr;
        }
        for(int itr=0;itr<n;itr++){
            int val=dp[itr];
            ans=min(val,ans);
        }
        return ans;
    }
};