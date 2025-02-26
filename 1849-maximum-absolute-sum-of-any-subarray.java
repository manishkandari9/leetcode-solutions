class Solution {
    private int maxSumSubarrayKadanes(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    public int maxAbsoluteSum(int[] nums) {
        int maxSumSubarray = maxSumSubarrayKadanes(nums);

        // Flip all signs
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }

        int minSumSubarray = maxSumSubarrayKadanes(nums);

        return Math.max(maxSumSubarray, minSumSubarray);
    }
}
