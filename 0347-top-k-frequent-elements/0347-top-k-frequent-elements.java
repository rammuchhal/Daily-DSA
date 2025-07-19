class CustomClass{
    int a;
    int b;
    CustomClass(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        // PriorityQueue<CustomClass> pq=new PriorityQueue<>((a,b)-> a.a-b.a);

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));

        // for(Map.Entry<Integer,Integer> ele:map.entrySet()){
        //     pq.add(new CustomClass(ele.getValue(),ele.getKey()));
        //     if(pq.size()>k){
        //         pq.poll();
        //     }
        // }

        for(int n:map.keySet()){
            pq.add(n);
            if(pq.size()>k) pq.poll();
        }

        int[] ans=new int[k];

        while(k-->0){
            ans[k]=pq.poll();
        }

        return ans;
    }
}