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
        DisjointSet ds = new DisjointSet(n);
    
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];
                
                // We can join stones only if at-least one of their co-ordinates are equal. 
                if(stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    ds.union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int num = ds.findUltimateParent(i);
            // System.out.println(num);
            set.add(num);
        }
        // System.out.println(set.size());
        int ans = n - set.size();
        return ans;
    }
}