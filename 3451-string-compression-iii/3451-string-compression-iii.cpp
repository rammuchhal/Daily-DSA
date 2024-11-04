class Solution {
public:
    string compressedString(string word) {
        string comp;
        char prev = word[0];
        int cnt = 1;

        for(int i=1;i<word.size();i++){
            if(word[i] == prev){
                cnt++;
                if(cnt>9){
                    comp.push_back('9');
                    comp.push_back(prev);
                    cnt = 1;
                }
            }
            else{
                comp += to_string(cnt) ;
                comp.push_back(prev);
                prev = word[i];
                cnt = 1;
            }
        }
        comp += to_string(cnt);
        comp.push_back(prev);
        return comp;
    }
};