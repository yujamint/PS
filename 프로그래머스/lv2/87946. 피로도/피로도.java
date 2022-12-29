class Solution {
    static int answer = 0;
    static boolean[] ch;

    public int solution(int k, int[][] dungeons) {
        ch = new boolean[dungeons.length];

        DFS(0, 0, k, dungeons);
        
        return answer;
    }

    public void DFS(int L, int count, int k, int[][] dungeons) {
        if (L == dungeons.length) {
            answer = Math.max(answer, count);
        }
        else {
            boolean end = true;
            for (int i = 0; i < dungeons.length; i++) {
                if (ch[i] || k < dungeons[i][0]) continue;

                end = false;
                ch[i] = true;
                DFS(L + 1, count + 1, k - dungeons[i][1], dungeons);
                ch[i] = false;
            }
            if (end) DFS(dungeons.length, count, k, dungeons);
        }
    }
}