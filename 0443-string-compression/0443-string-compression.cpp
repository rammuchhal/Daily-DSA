class Solution {
public:
    int compress(vector<char>& chars) {
        int i=0,l=0;
        while(i<chars.size()){
            char ch=chars[i];
            int j=i+1;
            while(j<chars.size() && ch==chars[j]){
                j++;
            }
            chars[l++]=chars[i];
            int cnt=j-i;
            if(cnt>1){
                string count=to_string(cnt);
                for(char chr:count){
                    chars[l++]=chr;
                }
            }
            i=j;
        }
        return l;
    }
};