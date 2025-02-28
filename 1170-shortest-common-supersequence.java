class Solution {
    private String findLCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        // Build the DP table for LCS
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Reconstruct the LCS from the DP table
        StringBuilder lcs = new StringBuilder();
        int i = len1, j = len2;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        // Reverse to get the correct order
        return lcs.reverse().toString();
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        String lcs = findLCS(str1, str2);
        
        int p1 = 0, p2 = 0;
        for (char c : lcs.toCharArray()) {
            // Add all non-LCS characters from str1
            while (p1 < str1.length() && str1.charAt(p1) != c) {
                ans.append(str1.charAt(p1++));
            }
            // Add all non-LCS characters from str2
            while (p2 < str2.length() && str2.charAt(p2) != c) {
                ans.append(str2.charAt(p2++));
            }
            // Add the LCS character
            ans.append(c);
            p1++;
            p2++;
        }
        
        // Add remaining characters from str1 and str2
        ans.append(str1.substring(p1));
        ans.append(str2.substring(p2));
        return ans.toString();
    }
}