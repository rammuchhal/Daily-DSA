class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        int n = A.size();
        vector<int> prefixCommonArray(n);

        unordered_set<int> elementsInA, elementsInB;

        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            elementsInA.insert(A[currentIndex]);
            elementsInB.insert(B[currentIndex]);

            int commonCount = 0;

            for (int element : elementsInA) {
                if (elementsInB.count(element)) {
                    ++commonCount;
                }
            }

            prefixCommonArray[currentIndex] = commonCount;
        }
        return prefixCommonArray;
    }
};