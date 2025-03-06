class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n=nums.size();
        vector<int> dp(n,1),hash(n);
        int maxI=1,lastI=0;
        sort(nums.begin(),nums.end());

        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int pr=0;pr<i;pr++){
                if(nums[i]%nums[pr]==0 && dp[i]<1+dp[pr]){
                    dp[i]=1+dp[pr];
                    hash[i]=pr;
                }
            }
            if(maxI<dp[i]){
                maxI=dp[i];
                lastI=i;
            }
        }

        vector<int> temp;
        temp.push_back(nums[lastI]);

        while(maxI!=temp.size()){
            lastI=hash[lastI];
            temp.push_back(nums[lastI]);
        }

        reverse(temp.begin(),temp.end());
        return temp;
    }
};