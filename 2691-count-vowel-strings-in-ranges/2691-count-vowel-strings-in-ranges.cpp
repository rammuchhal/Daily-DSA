class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int> ans(queries.size(),0);
        vector<int> preSumvowel(words.size(),0);
        int count=0;
        for(int i=0;i<words.size();i++){
            int endI = words[i].size()-1;
            cout<<words[i][0]<<" "<<words[i][endI]<<" ";
            if( (words[i][0]=='a' || words[i][0]=='e' || words[i][0]=='i' || words[i][0]=='o' || words[i][0]=='u') 
                && (words[i][endI]=='a' || words[i][endI]=='e' || words[i][endI]=='i' || words[i][endI]=='o' || words[i][endI]=='u') ){
                    count= count+1;   
                    cout<<count<<" ";
                }
                cout<<count<<" ";
                preSumvowel[i] = count;
        }
        for(int i=0;i<preSumvowel.size();i++){
            cout<<preSumvowel[i]<<" ";
        }

        for(int i=0;i<queries.size();i++){
            int start=queries[i][0],end=queries[i][1];
            if(start==0) ans[i]=preSumvowel[end];
            else{
                if(preSumvowel[start]==preSumvowel[start-1]) ans[i]=preSumvowel[end]-preSumvowel[start];
                else ans[i]=preSumvowel[end]-preSumvowel[start]+1;
            }
        }
        return ans;
    }
};