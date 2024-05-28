import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, answer = -1;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        BFS(a, 1);
        System.out.println(answer);
    }

    private static void BFS(long num, int count) {
        if (flag || num > b) return;
        if (num == b) {
            answer = count;
            flag = true;
            return;
        }
        BFS(num * 2, count + 1);
        BFS(num * 10 + 1, count + 1);
    }

}
