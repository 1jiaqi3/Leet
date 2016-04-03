/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
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
    
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(i * n + j, m * n);
                    }
                    if (boundCheck(i + 1, j, m, n) && board[i + 1][j] == 'O') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (boundCheck(i, j + 1, m, n) && board[i][j + 1] == 'O') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.connected(m * n, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public boolean boundCheck(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
