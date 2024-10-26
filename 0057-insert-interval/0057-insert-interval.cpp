class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        intervals.push_back(newInterval);
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> ans;

        int start = intervals[0][0];
        int end = intervals[0][1];
        int i=0;

        while(i<intervals.size()){
            if(intervals[i][0]<=end){
                end = max(end,intervals[i][1]);
            }
            else{
                ans.push_back({start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        ans.push_back({start,end});
        return ans;
    }
};