import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] empty;
    static int[] gate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        empty = new boolean[g + 1];
        gate = new int[g + 1];

        for (int i = 0; i <= g; i++) {
            empty[i] = true;
        }

        for (int i = 1; i <= g; i++) {
            gate[i] = i;
        }

        int[] input = new int[p];
        for (int i = 0; i < p; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < p; i++) {
            int plain = input[i];

            int pos = plain;
            while (!empty[pos]) {
                pos = gate[pos];
            }

            if (pos == 0) break;

            empty[pos] = false;

            int temp = pos - 1;
            while (temp != 0 && temp != gate[temp]) {
                temp = gate[temp];
            }
            gate[plain] = temp;
            gate[pos] = temp;
        }

        int count = 0;
        for (int i = 1; i <= g; i++) {
            if (!empty[i]) count++;
        }
        System.out.println(count);
    }
}
