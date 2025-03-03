class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int n=nums.size();

        vector<int> k,l,m;
        for(int i:nums){
            if(i<pivot){
                k.push_back(i);
            }
            else if(i==pivot){
                l.push_back(i);
            }
            else{
                m.push_back(i);
            }
        }
        int i=0;
        for(int p:k){
            nums[i++]=p;
        }
        for(int p:l){
            nums[i++]=p;
        }
        for(int p:m){
            nums[i++]=p;
        }

        return nums;
    }
};