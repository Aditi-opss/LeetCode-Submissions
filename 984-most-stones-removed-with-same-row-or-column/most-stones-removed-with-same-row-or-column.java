class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < parent.length; i++) {
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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        System.out.println(n);
        DisjointSet ds = new DisjointSet(20005);
    
        for(int i = 0; i < n; i++) {
            ds.union(stones[i][0], stones[i][1] + 10001);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(ds.findUltimateParent(stones[i][0]));
        }
        
        return n-set.size();
    }
}