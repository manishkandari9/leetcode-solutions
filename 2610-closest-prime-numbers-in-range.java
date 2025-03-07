import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = getPrimesInRange(left, right);
        if (primes.size() < 2)
            return new int[] { -1, -1 };

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;
    }

    private List<Integer> getPrimesInRange(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i])
                primes.add(i);
        }
        return primes;
    }
}
