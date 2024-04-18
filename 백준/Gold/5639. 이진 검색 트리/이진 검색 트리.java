import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            list.add(Integer.parseInt(input));
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }
        DFS(0, list.size() - 1);
        System.out.println(sb);
    }

    private static void DFS(int n, int end) {
        if (n > end) return;

        int mid = n + 1;
        while (mid <= end && list.get(mid) < list.get(n)) {
            mid++;
        }

        DFS(n + 1, mid - 1);
        DFS(mid, end);
        sb.append(list.get(n)).append('\n');
    }

}
