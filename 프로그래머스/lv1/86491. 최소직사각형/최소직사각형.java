class Solution {

    public int solution(int[][] sizes) {
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;

        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            wMax = Math.max(w, wMax);
            hMax = Math.max(h, hMax);
        }

        return wMax * hMax;
    }
}