class Solution {
public:
    bool candyDistriutionPossible(long long minCandies,vector<int>& candies,long long k){
        long long childCount = 0;
        int i=0;

        while(i<candies.size()){
                childCount += (candies[i]/minCandies);
                if(childCount>=k) return true;
                i++;
        }
        return childCount>=k? true:false;
    }
    int maximumCandies(vector<int>& candies, long long k) {
        int start = 0;
        int end = *max_element(candies.begin(),candies.end());

        long long maxCandies = 0;
        while(start<=end){
            long long mid = start+(end-start)/2;
            if(mid==0){
                start = mid+1;
            }
            else if(candyDistriutionPossible(mid,candies,k)){
                maxCandies = mid;
                start = mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return maxCandies;
    }
};