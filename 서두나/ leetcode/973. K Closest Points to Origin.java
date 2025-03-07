class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();

        int cnt = 0;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            list.add(new int[] { x * x + y * y, cnt++ });
        }

        list.sort((o1, o2) -> o1[0] - o2[0]);

        int[][] ans = new int[k][];

        for (int i = 0; i < k; i++) {
            ans[i] = points[list.get(i)[1]];
        }

        return ans;
    }
}
