/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    private class UnionFind {
        private int[] parent;
        private int[] size;
    
        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int root(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }
    
        public void union(int p, int q) {
            int pRoot = root(p);
            int qRoot = root(q);
            if (pRoot == qRoot) {
                return;
            }
            if (size[p] < size[q]) {
                parent[pRoot] = qRoot;
                size[q] += size[p]; 
            } else {
                parent[qRoot] = pRoot;
                size[p] += size[q];
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (boundCheck(i + 1, j, m, n) && grid[i + 1][j] == '1') {
                        uf.union((i * n + j), (i + 1) * n + j);
                    }
                    if (boundCheck(i, j + 1, m, n) && grid[i][j + 1] == '1') {
                        uf.union((i * n + j), i * n + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int root = uf.root(i * n + j);
                    if (!set.contains(root)) {
                        set.add(root);
                    }
                }
            }
        }
        return set.size();
    }
    
    public boolean boundCheck(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
