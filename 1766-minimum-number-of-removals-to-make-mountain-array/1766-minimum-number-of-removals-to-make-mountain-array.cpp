class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        int n = nums.size();
        vector<int> Lis(n,1);
        vector<int> Lds(n,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) Lis[i] = max(Lis[i],Lis[j]+1);
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j]) Lds[i] = max(Lds[i],Lds[j]+1);
            }
        }
        int EleInvoleInMountain = 0;

        for(int i=0;i<n;i++){
            if((Lis[i] == 1) || (Lds[i] == 1)){
                continue;
            }
            EleInvoleInMountain = max(EleInvoleInMountain,(Lis[i]+Lds[i]-1)) ; //adding that peak element
        }
        return n-EleInvoleInMountain ;
    }
};