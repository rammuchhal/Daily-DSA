class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int size=strs.size();
        int sizeFirstStr=strs[0].size();
        int i=0,j=0;
        string ans="";

        while(j<sizeFirstStr){
            char ch=strs[0][j];
            bool gotCommon=true;
            i=0;
            while(i<size){
                if(strs[i].size()>j && ch==strs[i][j]) i++;
                else{
                    if(strs[i].size()<=j) return ans;
                    gotCommon=false;
                    break;
                }
            }
            if(gotCommon) ans+=ch;
            else break;
            j++;
        }
        return ans;
    }
};