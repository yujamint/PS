import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken());
        int[] arr = new int[n];
        input = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }
        mergeSort(arr, 0, arr.length - 1);

        int result = list.size() < k ? -1 : list.get(k - 1);
        System.out.println(result);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int t = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                tmp[t++] = arr[i++];
            }
            else {
                list.add(arr[j]);
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            list.add(arr[i]);
            tmp[t++] = arr[i++];
        }
        while (j <= end) {
            list.add(arr[j]);
            tmp[t++] = arr[j++];
        }

        t = 0;
        while (start <= end) {
            arr[start++] = tmp[t++];
        }
    }
}
