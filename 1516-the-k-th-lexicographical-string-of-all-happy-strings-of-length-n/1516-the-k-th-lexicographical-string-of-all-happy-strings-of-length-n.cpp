class Solution {
public:
    string getHappyString(int n, int k) {
        string currentString = "";
        string result = "";
        int indexInSortedList = 0;

        // Generate happy strings and track the k-th string
        generateHappyStrings(n, k, currentString, indexInSortedList, result);
        return result;
    }

private:
    void generateHappyStrings(int n, int k, string &currentString,
                              int &indexInSortedList, string &result) {
        // If the current string has reached the desired length
        if (currentString.size() == n) {
            indexInSortedList++;  // Increment the count of generated strings

            if (indexInSortedList == k) result = currentString;
            return;
        }

        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (currentString.size() > 0 && currentString.back() == currentChar)
                continue;

            currentString += currentChar;

            generateHappyStrings(n, k, currentString, indexInSortedList,
                                 result);

            if (result != "") return;

            currentString.pop_back();
        }
    }
};