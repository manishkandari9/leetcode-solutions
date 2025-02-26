import java.util.*;

class Solution {
    private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {
        if (bob == 0) {
            bobPath.addAll(currPath);
            return true;
        }
        currPath.add(bob);