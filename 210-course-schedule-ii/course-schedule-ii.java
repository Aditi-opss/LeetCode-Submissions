class Solution {
    int[] ans;
    int index = 0;
    public int[] findOrder(int n, int[][] prerequisites) {
        ans = new int[n];
        List<Integer>[] adj = new List[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        } 

        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(visited[i] == false && dfsToDetectCycle(adj, visited, pathVisited, i))
                return new int[] {};   
        }
        return ans;
    }

    public boolean dfsToDetectCycle(List<Integer>[] adj, boolean[] visited, boolean[] pathVisited, int source) {
        visited[source] = true;
        pathVisited[source] = true;
         
        for(int node : adj[source]) {
            if (visited[node] == false && dfsToDetectCycle(adj, visited, pathVisited, node))
                return true;
            else if (pathVisited[node] == true)
                return true;
        }
        ans[index++] = source;
        pathVisited[source] = false;
        return false;
    }
}