class Solution {
    public boolean checkPowersOfThree(int n) {
        // All the digits of base-3 number must be either 0 or 1
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}