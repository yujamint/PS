import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {

    int from;
    int to;

    public Time(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Time o) {
        if (to == o.to) {
            return from - o.from;
        }
        return to - o.to;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int end = 0;
        int cnt = 0;
        for (Time time : list) {
            if (time.from >= end) {
                end = time.to;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
