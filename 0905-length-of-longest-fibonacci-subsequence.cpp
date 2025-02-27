
//Approach-1: Greedy Simulation...TC: O(N^2 logM)...SC: O(N)
class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        int n=arr.size();
        unordered_set<int> values(arr.begin(),arr.end());
        
        int longest=0;
        for(int i=0;i<n-1;++i){
            for(int j=i+1;j<n;++j){
                int a = arr[i];
                int b = arr[j];
                int fib_len = 2;
                while(values.count(a+b)>0){
                    int sum = a+b;
                    a = b;
                    b = sum;
                    fib_len++;
                }
                if(fib_len>2)
                    longest = max(longest,fib_len);
            }
        }
        return longest;
    }
};