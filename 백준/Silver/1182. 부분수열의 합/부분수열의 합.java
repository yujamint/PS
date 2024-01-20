import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,s,answer = 0;
    static int[] arr, ch;

    public static void DFS(int count, int sum) {
        if (count == n) {
            if (sum == s) answer++;
        } else {
            ch[count] = 1;
            DFS(count + 1, sum + arr[count]);
            ch[count] = 0;
            DFS(count + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st1.nextToken());
        s = Integer.parseInt(st1.nextToken());
        arr = new int[n];
        ch = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        DFS(0, 0);

        if (s == 0) System.out.println(answer - 1);
        else System.out.println(answer);

    }
}
