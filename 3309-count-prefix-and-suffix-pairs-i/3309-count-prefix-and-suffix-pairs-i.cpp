class Solution {
public:
    bool isPrefixAndSuffix(string str1,string str2){
        int n=str1.size(),m=str2.size();
        return ( (n<=m) && (str1 == str2.substr(0,n)) && (str1 == str2.substr(m-n,n)) )? true:false;
    }
    int countPrefixSuffixPairs(vector<string>& words) {
        int count=0;
        for(int i=0;i<words.size()-1;i++){
            for(int j=i+1;j<words.size();j++)
                if(isPrefixAndSuffix(words[i],words[j])) count++;
        }
        return count;
    }
};