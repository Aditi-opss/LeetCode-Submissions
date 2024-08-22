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
        if(parent[p] == p) return p;

        return parent[p] = findUltimateParent(parent[p]);
    }

    public void union(int u, int v) {
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);

        if(pu == pv) return;

        int rpu = rank[pu];
        int rpv = rank[pv];

        if(rpu > rpv) parent[pv] = pu;
        else if(rpu < rpv) parent[pu] = pv;
        else {
            parent[pv] = pu;
            rank[pu]++; 
        }
    }

}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1)
                    ds.union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(ds.findUltimateParent(i));
        }
        return set.size();
    }
}