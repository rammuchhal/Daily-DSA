class Solution {
public:
    void getletterCombi(vector<string>& ans,string& combi,int& n,int i,string digits,vector<string>& mapping){
        if(i>=n){
            if(!combi.empty()) ans.push_back(combi);
            return;
        }
        int num=digits[i]-'0';
        string value=mapping[num];

        for(int j=0;j<value.size();j++){
            combi.push_back(value[j]);
            getletterCombi(ans,combi,n,i+1,digits,mapping);
            combi.pop_back();
        }
    }
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        string combi="";
        int n=digits.size();
        vector<string> mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        getletterCombi(ans,combi,n,0,digits,mapping);
        return ans;
    }
};