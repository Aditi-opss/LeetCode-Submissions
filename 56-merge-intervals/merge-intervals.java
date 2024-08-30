class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] newInterval = new int[2];
        newInterval[0] = intervals[0][0];
        newInterval[1] = intervals[0][1];
        
        for(int[] slot : intervals) {
            if(newInterval[1] < slot[0]) {
                res.add(newInterval);
                newInterval = slot;
            }
            else if(newInterval[0] > slot[1]) {
                res.add(slot);
            }
            else {
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}