class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int> ans(queries.size(),0);
        vector<int> preSumvowel(words.size()+1,0);

        unordered_set<char> vowel;
        vowel.insert({'a','e','i','o','u'});

        int count=0;
        for(int i=0;i<words.size();i++){
            int endI = words[i].size()-1;
            if( vowel.find(words[i][0])!=vowel.end() && vowel.find(words[i][endI])!=vowel.end()) count++;   
                preSumvowel[i+1] = count;
        }

        for(int i=0;i<queries.size();i++){
            int start=queries[i][0],end=queries[i][1];
            ans[i]=preSumvowel[end+1]-preSumvowel[start];
        }
        return ans;
    }
};