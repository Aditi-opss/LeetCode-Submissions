class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
        List<int[]>[] adj = new List[n + 1];

        //make new list at every index to store adj nodes and their weight
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        //List is integer array of size 2 at every index
        //here you will be storing weight and adj index 
        for(int i = 0; i < times.length; i++) {
            int index = times[i][0];
            adj[index].add(new int[]{times[i][2], times[i][1]});   
        }

        int[] distance = new int[n + 1];
        //by default we make all the values as max
        Arrays.fill(distance, Integer.MAX_VALUE);
        //we make source value as 0
        distance[k] = 0; 
        
        //make minHeap to check on int array of weight and adj index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->  a[0] - b[0]);

        minHeap.add(new int[]{0, k}); //add source i.e k here and it's distance

        while(minHeap.size() > 0) {
            int[] curr = minHeap.remove();
            for(int[] adjCurrArr : adj[curr[1]]) {
                int dist = adjCurrArr[0]; 
                int node = adjCurrArr[1]; 

                //here we are comparing distance of node with dist of curr node to its adj node
                //and distance of curr[i] -> to check on previous distance to reach that node
                if(distance[node] > dist + distance[curr[1]]) {
                    distance[node] = dist + distance[curr[1]];
                    minHeap.add(new int[] {distance[node], node});
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, distance[i]);
        }
        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }
}