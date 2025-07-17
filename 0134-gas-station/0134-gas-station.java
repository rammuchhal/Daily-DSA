class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;

        for(int i=0;i<n;i++){
            int k=i;
            int currGas=0;
            for(int j=0;j<n;j++){
                currGas+=gas[k%n];
                int costGiven=cost[k%n];
                k++;

                currGas-=costGiven;
                if(currGas<=0) break;
            }
            if(i==(k%n) && currGas>=0) return i;
        }
        return -1;
    }
}