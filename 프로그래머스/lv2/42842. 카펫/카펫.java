class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) {
                continue;
            }

            int line = yellow / i + 2;

            if (line * (i + 2) == total) {
                answer[0] = line;
                answer[1] = i + 2;
                break;
            }
        }

        return answer;
    }
}