import java.util.Arrays;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        
        int left = 0, right = n - 1;
        int leftRes = 0, rightRes = n - 1;
        
        while (left < n) {
            if (nums[left] < pivot) {
                res[leftRes++] = nums[left];
            }
            if (nums[right] > pivot) {
                res[rightRes--] = nums[right];
            }
            left++;
            right--;
        }
        
        while (leftRes <= rightRes) {
            res[leftRes++] = pivot;
        }
        
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] result = solution.pivotArray(nums, pivot);
        System.out.println(Arrays.toString(result));
    }
}