class Solution {
public:
    int countPalindromicSubsequence(string s) {
        unordered_set<char> chr;
        for(char c:s){
            chr.insert(c);
        }

        int ans=0;
        for(char c:chr){
            int i = -1;
            int j = 0;
            
            for(int k=0;k<s.size();k++){
                if(s[k]==c){
                    if(i==-1){
                        i=k;
                    }
                    j=k;
                }
            }

            unordered_set<char> pals;
            for(int k=i+1;k<j;k++){
                pals.insert(s[k]);
            }
            ans+=pals.size();
        }
        return ans;
    }
};