class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int prev=0;
        int curr=1;

        for(int i=2;i<=n+1;i++){
            int nxtVal=prev+curr;
            prev=curr;
            curr=nxtVal;
        }
        return prev;
    }
}