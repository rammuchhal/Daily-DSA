class Solution {
public:
    bool rotateString(string s, string goal) {
        int size = s.size();
        if(size != goal.size()) return false;
        int i=size;
        while(i--){
            rotate(s.begin(), s.begin() + 1, s.end());
            if(s==goal) return true;
        }
        return false;
    }
};