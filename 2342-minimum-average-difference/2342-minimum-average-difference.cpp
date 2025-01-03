class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        long long rightsum=0;
        for(auto i:nums){
            rightsum+=i;
        }
        int n=nums.size();
        long long leftSum=0;
        pair<int,int> p = {-1,INT_MAX};

        double leftavg,rightavg;
        for(int i=0;i<n;i++){
            leftSum+=nums[i];
            rightsum-=nums[i];

            leftavg = leftSum/(i+1);
            if(i==n-1) rightavg=0;
            else rightavg = rightsum/(n-i-1);
            int mindiff=abs( round(leftavg)-round(rightavg) );
            if(p.second>mindiff){
                p = {i,mindiff};
            }
        }
        return p.first;
    }
};