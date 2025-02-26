import java.util.*;

class Solution {
    private boolean findBobPath(List<List<Integer>> adj, int bob, int parent, List<Integer> currPath,
            List<Integer> bobPath) {
        if (bob == 0) {
            bobPath.addAll(currPath);
            return true;
        }
        currPath.add(bob);
        for (int nbr : adj.get(bob)) {
            if (nbr != parent && findBobPath(adj, nbr, bob, currPath, bobPath)) {
                return true;
            }
        }
        currPath.remove(currPath.size() - 1);
        return false;
    }

    private int findMaxIncomeForAlice(List<List<Integer>> adj, int alice, int parent, int[] amount) {
        int maxIncome = Integer.MIN_VALUE;
        for (int nbr : adj.get(alice)) {
            if (nbr != parent) {
                int income = findMaxIncomeForAlice(adj, nbr, alice, amount);
                if (income + amount[alice] > maxIncome) {
                    maxIncome = income + amount[alice];
                }
            }
        }
        return maxIncome == Integer.MIN_VALUE ? amount[alice] : maxIncome;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> currPath = new ArrayList<>();
        List<Integer> bobPath = new ArrayList<>();
        findBobPath(adj, bob, -1, currPath, bobPath);

        int size = bobPath.size();
        int i;
        for (i = 0; i < size / 2; ++i) {
            amount[bobPath.get(i)] = 0;
        }
        if (size % 2 == 1) {
            amount[bobPath.get(i)] = 0;
        } else {
            amount[bobPath.get(i)] /= 2;
        }
        return findMaxIncomeForAlice(adj, 0, -1, amount);
    }
}