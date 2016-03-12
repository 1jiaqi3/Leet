/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / fact[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            k = k - fact[n - i] * index;
            numbers.remove(index);
        }
        return sb.toString();
    }
}
