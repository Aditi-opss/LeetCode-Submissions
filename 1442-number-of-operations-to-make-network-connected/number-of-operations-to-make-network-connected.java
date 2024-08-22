class DisjointSet {
    int[] parent;
    int[] rank;
    int extraEdges;

    DisjointSet(int n) {
        parent =  new int[n];
        rank = new int[n];
        extraEdges = 0;

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

        if(pu == pv) {
            extraEdges++;
            return;
        }

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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < connections.length; i++) {
            ds.union(connections[i][0], connections[i][1]);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(ds.findUltimateParent(i));
        }
        // System.out.println(set.size());
        // System.out.println(ds.extraEdges);
    
        if(set.size() - 1 <= ds.extraEdges) {
            return set.size() - 1;
        }

        return -1;
    }
}