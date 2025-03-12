class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int n = nums.size();
        int lb = lower_bound(nums.begin(),nums.end(),0)-nums.begin();
        int ub = upper_bound(nums.begin(),nums.end(),0)-nums.begin();

        return max(lb,n-ub);
    }
};