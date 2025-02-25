}
currPath.add(bob);
for (int nbr : adj.get(bob)) {
if (nbr != parent && findBobPath(adj, nbr, bob, currPath, bobPath)) {
return true;
bobPath.addAll(currPath);
return true;
class Solution {
private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {
if (bob == 0) {
import java.util.*;

}
}
currPath.remove(currPath.size() - 1);
return false;
}