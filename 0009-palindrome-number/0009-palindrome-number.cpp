class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;

        int n=x;
        int rev=0;

        while(n!=0){
            int digit=n%10;
            if( rev >(INT_MAX/10) ) return false;
            rev=rev*10+digit;
            n/=10;
        }

        return rev==x;
    }
};