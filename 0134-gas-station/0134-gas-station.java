class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int front=0,rear=0,remainP=0,n=gas.length;

        while(front<n){
            remainP += (gas[rear%n]-cost[rear%n]);
            if(remainP<0){
                front=rear+1;
                rear=front;
                remainP=0;
            }
            else{
                rear++;
                if(front == (rear%n)) return front;
            }
        }
        return -1;
    }
}