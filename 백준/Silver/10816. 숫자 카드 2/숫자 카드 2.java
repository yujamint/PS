import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int RANGE = 10_000_000;

    static int n,m;
    static int[] card;
    static int[] numberOfCard = new int[2 * RANGE + 1];

    public static int binarySearch(int x) {
        int front = 0, rear = n - 1;
        while (front <= rear) {
            int mid = (front + rear) / 2;

            if (card[mid] == x) {
                return numberOfCard[x + RANGE];
            }
            if (card[mid] < x) {
                front = mid + 1;
                continue;
            }
            rear = mid - 1;
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
            numberOfCard[card[i] + RANGE] += 1;
        }
//        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(numberOfCard[x + RANGE]).append(' ');
//            sb.append(binarySearch(x)).append(' ');
        }
        System.out.println(sb);
    }
}
