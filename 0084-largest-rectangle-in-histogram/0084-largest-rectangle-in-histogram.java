class Solution {
    private int[] nextSmallerElement(int[] heights,int n){
        int[] ans=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        int i=n-1;

        while(i>=0){
            int currEle=heights[i];
            if(s.peek()==-1 || heights[s.peek()]<currEle){
                ans[i]=s.peek();
                s.push(i);
                i--;
            }
            else s.pop();
        }
        return ans;
    }
    private int[] prevSmallerElement(int[] heights,int n){
        int ans[] = new int[n];
        int i=0;
        Stack<Integer> s=new Stack<>();
        s.push(-1);

        while(i<n){
            int currEle=heights[i];
            if(s.peek()==-1 || heights[s.peek()]<currEle){
                ans[i]=s.peek();
                s.push(i);
                i++;
            }
            else s.pop();
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] next=nextSmallerElement(heights,n);
        int[] prev=prevSmallerElement(heights,n);
        int area=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(next[i]==-1) next[i]=n;

            int width=next[i]-prev[i]-1;
            area=Math.max(area,heights[i]*width);
        }
        return area;
    }
}