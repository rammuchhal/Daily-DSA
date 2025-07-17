class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainP=0,deficiency=0,start=0,n=gas.length;
        
        for(int i=0;i<n;i++){
            remainP+=(gas[i]-cost[i]);
            if(remainP<0){
                deficiency+=remainP;
                remainP=0;
                start=i+1;
            }
        }
        return remainP+deficiency>=0? start:-1;
    }
}