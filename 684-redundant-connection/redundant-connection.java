class DisjointSet {
    int[] parent;
    int[] rank;
    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int findUltimateParent(int p) {
        if(parent[p] == p) 
            return p;
        return parent[p] = findUltimateParent(parent[p]);
    }

    public void union(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if(pu == pv) return;

        int rpu = rank[pu];
        int rpv = rank[pv];

        if(rpu > rpv) 
            parent[pv] = pu;
        else if(rpu < rpv)
            parent[pu] = pv;
        else {
            parent[pv] = pu;
            rank[pu] = 1 + rank[pu];
        } 
    }

}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n + 1);
        
        for(int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(ds.findUltimateParent(u) == ds.findUltimateParent(v))
                return new int[] {u, v};

            ds.union(u, v);
        }
        return new int[]{-1, -1};
    }
}