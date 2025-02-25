import java.util.*;import java.util.*;

class Solution {class Solution {
    private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {    private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath, List<Integer> bobPath) {
        if (bob == 0) {        if (bob == 0) {
            bobPath.addAll(currPath);            bobPath.addAll(currPath);
            return true;            return true;
        }        }
        currPath.add(bob);        currPath.add(bob);
        for (int nbr : adj.get(bob)) {        for (int nbr : adj.get(bob)) {
            if (nbr != parent && findBobPath(adj, nbr, bob, currPath, bobPath)) {            if (nbr != parent && findBobPath(adj, nbr, bob, currPath, bobPath)) {
                return true;                return true;
            }            }
        }        }
        currPath.remove(currPath.size() - 1);        currPath.remove(currPath.size() - 1);
        return false;        return false;