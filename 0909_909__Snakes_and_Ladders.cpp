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
for (int nbr : adj.get(alice)) {
if (nbr != parent) {
bobPath.addAll(currPath);
return true;
int income = findMaxIncomeForAlice(adj, nbr, alice, amount);
if (income + amount[alice] > maxIncome) {
maxIncome = income + amount[alice];
}
}
}
return maxIncome == Integer.MIN_VALUE ? amount[alice] : maxIncome;
class Solution {
private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {
if (bob == 0) {
import java.util.*;