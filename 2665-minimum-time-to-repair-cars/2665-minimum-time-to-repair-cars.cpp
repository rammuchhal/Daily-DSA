class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        long long start = 1;
        long long maxEle = *max_element(ranks.begin(),ranks.end());
        long long end = maxEle * cars*cars ;
        long long minTime=0;

        while(start<=end){
            long long mid = start+(end-start)/2;
            long long repairedCars = 0;
            for(int i=0;i<ranks.size();i++)
                repairedCars += sqrt(mid/ranks[i]);
            if(repairedCars>=cars){
                minTime = mid;
                end = mid-1;
            }
            else start=mid+1;
        }
        return minTime;
    }
};