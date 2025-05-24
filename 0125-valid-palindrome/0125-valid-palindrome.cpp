class Solution {
public:
    bool checkPalindrome(string &newS){
        int first=0;
        int second=newS.size()-1;

        while(first<second)
            if(newS[first++]!=newS[second--]) return false;
        
        return true;
    }
    bool isPalindrome(string s) {
        int sSize=s.size();
        string newS;

        for(int i=0;i<sSize;i++){
            if(s[i]>='A' && s[i]<='Z'){ //to lower case
                newS.push_back((s[i]-'A'+'a'));
            }
            else if( (s[i]>='a' && s[i]<='z') || (s[i]>='0' && s[i]<='9') ){
                newS.push_back(s[i]);
            }
        }

        return checkPalindrome(newS);
    }
};