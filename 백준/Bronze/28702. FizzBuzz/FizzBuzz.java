import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }
        int nextNum = -1;
        for (int i = 0; i < 3; i++) {
            char ch = arr[i].charAt(0);
            if (ch >= 49 && ch <= 57) {
                int num = Integer.parseInt(arr[i]);
                nextNum = num + 3 - i;
                break;
            }
        }
        if (nextNum % 3 == 0 && nextNum % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (nextNum % 3 == 0) {
            System.out.println("Fizz");
        } else if (nextNum % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(nextNum);
        }
    }

}
