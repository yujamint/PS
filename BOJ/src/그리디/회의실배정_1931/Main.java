package 그리디.회의실배정_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] ch;
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());

        Meeting[] arr = new Meeting[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Meeting(start, end);

            max = Math.max(max, end);
        }
        ch = new boolean[max + 1];

        Arrays.sort(arr);

        int prevEnd = 0;
        for (Meeting meeting : arr) {
            int start = meeting.start;
            int end = meeting.end;

            if (start >= prevEnd) {
                prevEnd = end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
