class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        // Build adjacency list representation of the tree
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.putIfAbsent(edge[0], new HashSet<>());
            adjList.putIfAbsent(edge[1], new HashSet<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Initialize the set of leaf nodes
        List<Integer> leaves = new ArrayList<>();
        for (int node : adjList.keySet()) {
            if (adjList.get(node).size() == 1) {
                leaves.add(node);
            }
        }

        // Trim the leaves and update the adjacency list until at most 2 nodes are left
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                if (adjList.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
