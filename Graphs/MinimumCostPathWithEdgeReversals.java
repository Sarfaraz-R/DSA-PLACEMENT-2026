/*
You are given a directed, weighted graph with n nodes labeled from 0 to n - 1, and an array edges where edges[i] = [ui, vi, wi] represents a directed edge from node ui to node vi with cost wi.

Each node ui has a switch that can be used at most once: when you arrive at ui and have not yet used its switch, you may activate it on one of its incoming edges vi → ui reverse that edge to ui → vi and immediately traverse it.

The reversal is only valid for that single move, and using a reversed edge costs 2 * wi.

Return the minimum total cost to travel from node 0 to node n - 1. If it is not possible, return -1.

 

Example 1:

Input: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]

Output: 5

Explanation:



Use the path 0 → 1 (cost 3).
At node 1 reverse the original edge 3 → 1 into 1 → 3 and traverse it at cost 2 * 1 = 2.
Total cost is 3 + 2 = 5.
Example 2:

Input: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]

Output: 3

Explanation:

No reversal is needed. Take the path 0 → 2 (cost 1), then 2 → 1 (cost 1), then 1 → 3 (cost 1).
Total cost is 1 + 1 + 1 = 3.
 

Constraints:

2 <= n <= 5 * 10^4
1 <= edges.length <= 10^5
edges[i] = [ui, vi, wi]
0 <= ui, vi <= n - 1
1 <= wi <= 1000
 */

class Solution {
  class Pair {
    int node;
    int cost;

    public Pair(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }

  public int minCost(int n, int[][] edges) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());
    for (int[] e : edges) {
      int u = e[0];
      int v = e[1];
      int c = e[2];
      adj.get(u).add(new Pair(v, c));
      adj.get(v).add(new Pair(u, 2 * c));
    }
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[] { 0, 0 });
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int node = cur[0];
      int d = cur[1];
      ArrayList<Pair> neighBours = adj.get(node);
      for (int i = 0; i < neighBours.size(); i++) {
        Pair p = neighBours.get(i);
        int neighbour = p.node;
        int cost = p.cost;
        if (cost + d < dist[neighbour]) {
          dist[neighbour] = cost + d;
          pq.offer(new int[] { neighbour, cost + d });
        }
      }
    }
    return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
  }
}