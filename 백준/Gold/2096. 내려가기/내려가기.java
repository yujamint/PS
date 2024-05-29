import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] colMax = new int[3], colMin = new int[3], tempMax = new int[3], tempMin = new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tempMax[j] = Integer.parseInt(st.nextToken());
                tempMin[j] = tempMax[j];
                tempMax[j] += Math.max(colMax[1], j == 1 ? Math.max(colMax[0], colMax[2]) : colMax[j]);
                tempMin[j] += Math.min(colMin[1], j == 1 ? Math.min(colMin[0], colMin[2]) : colMin[j]);
            }
            System.arraycopy(tempMax, 0, colMax, 0, tempMax.length);
            System.arraycopy(tempMin, 0, colMin, 0, tempMin.length);
        }
        int max = Math.max(colMax[0], Math.max(colMax[1], colMax[2]));
        int min = Math.min(colMin[0], Math.min(colMin[1], colMin[2]));
        System.out.println(max + " " + min);
    }
}
