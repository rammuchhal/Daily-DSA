class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<int>> after(2,vector<int>(3,0)),curr(2,vector<int>(3,0));

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int tran=1;tran<=2;tran++){
                    if(buy){
                        curr[1][tran]=max(-prices[i]+after[0][tran],after[1][tran]);
                    }
                    else{
                        curr[0][tran]=max(prices[i]+after[1][tran-1],after[0][tran]);
                    }
                }
            }
            after=curr;
        }

        return after[1][2];
    }
};