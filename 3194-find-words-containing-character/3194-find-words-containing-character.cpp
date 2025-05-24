class Solution {
public:
    vector<int> findWordsContaining(vector<string>& words, char x) {
        vector<int> ans;

        for(int i=0;i<words.size();i++){
            int size=words[i].size();
            for(int j=0;j<size;j++){
                if(words[i][j]==x) {
                    ans.push_back(i);
                    break;
                }
            }
        }
        return ans;
    }
};