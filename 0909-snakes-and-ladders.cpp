import java.util.*;
class Solution {
private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {
if (bob == 0) {
bobPath.addAll(currPath);
return true;
}
currPath.add(bob);
for (int nbr : adj.get(bob)) {
if (nbr != parent && findBobPath(adj, nbr, bob, currPath, bobPath)) {
return true;
}
}
currPath.remove(currPath.size() - 1);
return false;
}
private int findMaxIncomeForAlice(List<List<Integer>> adj, int alice, int parent, int[] amount) {
int maxIncome = Integer.MIN_VALUE;