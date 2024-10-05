class Solution {
public:
    bool checkequal(int arr1[26],int arr2[26]){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return 0;
            }
        }
        return 1;
    }
    bool checkInclusion(string s1, string s2) {
        if(s1.size()>s2.size()) return false;
        int count1[26]={0};
        for(int i=0;i<s1.size();i++){
            int index = s1[i] - 'a' ;
            count1[index]++;
        }

        int count2[26]={0};
        int windowSize=s1.size();
        int i=0;


        while(i<windowSize){
                count2[ s2[i] - 'a' ]++;
                i++;
            }
           
        if(checkequal(count1,count2))
              return 1;
                   
        while(i<s2.size()){
            
            count2[ s2[i] - 'a']++;

            count2[ s2[i-windowSize] - 'a' ]--;

            i++;

            if(checkequal(count1,count2))
                return 1;
            

        }
            return 0;

    }
};