package 이분탐색삼분탐색.숫자카드_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] card;

    public static int binarySearch(int x) {
        int front = 0, rear = card.length-1;

        while (front <= rear) {
            int mid = (front + rear) / 2;

            if (x == card[mid]) {
                return 1;
            }
            if (x < card[mid]) {
                rear = mid - 1;
                continue;
            }
            front = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(x)).append(' ');
        }

        System.out.println(sb);
    }
}
