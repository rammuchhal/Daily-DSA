class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];

        Arrays.fill(left,-1);
        Arrays.fill(right,n);

        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                left[i]=stk.peek();
            }
            stk.push(i);
        }
        stk.clear();

        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]> arr[i]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                right[i]=stk.peek();
            }
            stk.push(i);
        }

        int mod= (int)1e9+7;
        long answer=0;

        for(int i=0;i<n;i++){
            answer+=  (long) (i-left[i])*(right[i]-i)%mod * arr[i] % mod;
            answer %= mod;
        }
        return (int)answer;
    }
}