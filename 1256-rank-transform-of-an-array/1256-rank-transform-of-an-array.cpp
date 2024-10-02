class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        set<int> s;
        for(int i:arr){
            s.insert(i);
        }
        int j=1;
        map<int,int> m;
        for(auto value:s){
            m[value]=j;
            j++;
        }
        int size = arr.size();
        vector<int> ans(size);
        for(int i=0;i<size;i++){
            ans[i]=m[arr[i]];
        }
        return ans;

    }
};