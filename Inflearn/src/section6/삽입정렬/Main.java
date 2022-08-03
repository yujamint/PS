package section6.삽입정렬;

import java.util.Scanner;

public class Main {
    public int[] solution(int n, int[] arr) {
        //0번째 인덱스는 비교대상이 없으므로 1번쨰 인덱스부터 시작
        for (int i = 1; i < n; i++) {
            int tmp = arr[i]; // 정렬방식에 따라 삽입될 숫자를 tmp 변수로 복사

            //0~i-1번 인덱스까지는 정렬된 상태이므로, i번 인덱스까지 포함돼서 0~i번 정렬되도록 j를 i-1부터 0까지로 설정
            int j;
            for (j = i-1; j >= 0; j--) {
                    if(arr[j] > tmp) arr[j+1] = arr[j]; // tmp가 들어갈 위치를 찾기 위해 tmp보다 큰 수를 오른쪽으로 옮긴다.
                     else break; // tmp보다 작은 수가 들어있는 인덱스를 만나면 정지
            }
            arr[j+1] = tmp; // tmp보다 작은 수가 들어있는 인덱스의 바로 뒤에 tmp를 넣는다.

        }
        return arr;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i : m.solution(n, arr))
            System.out.print(i + " ");
    }
}
