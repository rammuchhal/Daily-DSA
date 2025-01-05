class Solution {
public:
    string shiftingLetters(string s, vector<vector<int>>& shifts) {
        vector<int> tobeShift(s.size() + 1, 0); 
        
        for (vector<int>& shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            if (direction == 0) {
                tobeShift[start] -= 1;
                tobeShift[end + 1] += 1;
            } else {
                tobeShift[start] += 1;
                tobeShift[end + 1] -= 1;
            }
        }
        
        for (int i = 1; i < tobeShift.size(); i++) {
            tobeShift[i] += tobeShift[i - 1];
        }
        
        for (int i = 0; i < s.size(); i++) {
            int shift = tobeShift[i] % 26;
            if (shift < 0) shift += 26;   
            s[i] = 'a' + (s[i] - 'a' + shift) % 26;
        }
        
        return s;
    }
};
