class Solution {
    private int[] nextSmallerElement(int[]heights,int n){
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
    private int[] prevSmallerElement(int[]heights,int n){
        int[] ans=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        int i=0;

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
    private int largestRectangleArea(int[] heights){
        int n=heights.length;
        int[] next=nextSmallerElement(heights,n);
        int[] prev=prevSmallerElement(heights,n);
        int max_area=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(next[i]==-1) next[i]=n;
            int width=next[i]-prev[i]-1;
            max_area=Math.max((width*heights[i]),max_area);
        }
        return max_area;
    }
    public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        int[] area=new int[cols];
        for(int i=0;i<cols;i++){
            area[i]=matrix[0][i]-'0';
        }
        int maxArea=largestRectangleArea(area);

        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    area[j] =area[j] +1;
                }
                else area[j]=0;
            }
            
            maxArea=Math.max(maxArea,largestRectangleArea(area));
        }
    
        return maxArea;
    }
}