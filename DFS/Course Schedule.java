/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. 
If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<Integer>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!DFS(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }
    public boolean DFS(int u, int[] visited, LinkedList<LinkedList<Integer>> graph) {
        visited[u] = -1;
        for (int i = 0; i < graph.get(u).size(); i++) {
            if (visited[graph.get(u).get(i)] == -1) {
                return false;
            } else if (visited[graph.get(u).get(i)] == 0 && !DFS(graph.get(u).get(i), visited, graph)) {
                return false;
            }
        }
        visited[u] = 1;
        return true;
    }
}
