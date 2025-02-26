class Solution {
    int maxSumSubarrayKadanes(vector<int>& nums) {
        int max_sum = INT_MIN;
        int curr_sum = 0;
        for (int ele : nums) {
            curr_sum += ele;
            max_sum = max(max_sum, curr_sum);
            if (curr_sum < 0)
                curr_sum = 0;
        }
        return max_sum;
    }

public:
    int maxAbsoluteSum(vector<int>& nums) {
        int max_sum_subarray = maxSumSubarrayKadanes(nums);

        // Flip all signs
        for (int i = 0; i < nums.size(); ++i)
            nums[i] = (-1) * nums[i];

        int min_sum_subarray = maxSumSubarrayKadanes(nums);
        return max(max_sum_subarray, min_sum_subarray);
    }
};