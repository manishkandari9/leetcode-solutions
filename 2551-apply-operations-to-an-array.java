import java.util.Arrays;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int nonZeroIdx = 0;

        // Apply operations
        for (int i = 0; i < n; ++i) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIdx];
                nums[nonZeroIdx] = temp;
                nonZeroIdx++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 2, 0, 3, 0, 4};
        int[] result = sol.applyOperations(nums);
        System.out.println(Arrays.toString(result)); // Output: [1, 4, 3, 4, 0, 0, 0]
    }
}
