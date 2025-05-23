class Solution {
public:
    bool isHappy(int n) {
      int cnt=1000000;

      while(cnt--){
        int ans=0;
        while(n!=0){
            int d=n%10;
            ans+=(d*d);
            n=n/10;
        }
        if(ans==1) return true;
        n=ans;
      }
      return false;
    }
};