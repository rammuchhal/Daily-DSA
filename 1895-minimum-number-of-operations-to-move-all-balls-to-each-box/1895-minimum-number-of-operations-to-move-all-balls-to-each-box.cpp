class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n=boxes.size();
        vector<int> answer(n,0);
        
        for(int i=0;i<n;i++){
            int sum=0;
            int bitVali= n-i-1;
            for(int j=0;j<n;j++){
                int bitValj=n-j-1;
                if(boxes[j]=='1'){
                    sum += abs(bitVali-bitValj);
                }
            }
            answer[i]=sum;
        }
        return answer;
    }
};