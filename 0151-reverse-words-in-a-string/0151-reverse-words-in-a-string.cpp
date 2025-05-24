class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        vector<string> arr;
        string word;
        while(ss>> word){
            arr.push_back(word);
        }
        s.clear();
        for(int i=arr.size()-1;i>=0;i--){
            s+=arr[i];
            if(i>0) s+=' ';
        }
        return s;
    }
};