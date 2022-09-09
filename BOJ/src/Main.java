import java.util.ArrayList;

public class Main {
    public static int d(int n) {
        int temp = n;
        String str = Integer.toString(n);
        for (char x : str.toCharArray()) {
            temp += x - '0';
        }
        return temp;
    }

    public static void main(String[] args){
        int[] dn = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            if (d(i) <= 10000) dn[d(i)] = 1;
        }

        for (int i = 1; i <= 10000; i++) {
            if(dn[i] == 0) System.out.println(i);
        }
    }
}