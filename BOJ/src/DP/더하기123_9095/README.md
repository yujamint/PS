# 1, 2, 3 더하기

**내 풀이방법**
- DFS로 해결했다.
- 1,2,3 중에 하나씩 더해가며 입력받은 n이 될 경우 경우의 수(answer)를 하나 증가시킨다.
- 만약 특정 숫자를 더했는데 n을 초과하는 숫자가 된다면 문제 조건을 만족하지 못 하므로 return한다.
- DP로 푼다면 더 빠른 시간 내에 실행될까?

Code
```java
package DP.더하기123_9095;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static int answer;

    public void DFS(int n, int sum) {
        if (sum > n) return;
        if (sum == n) answer++;
        else{
            for (int i = 1; i <= 3; i++) {
                DFS(n, sum + i);
            }
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : arr) {
            answer = 0;
            T.DFS(x, 0);
            System.out.println(answer);
        }

    }
}

```

**DP로 풀기**
- dy[1] = 1 => 1
- dy[2] = {1+1, 2} => 2
- dy[3] = {1+1+1, 1+2, 2+1, 3} => 4
- dy[4]는 다음과 같다.
    - 1 + 3 : 3을 1,2,3으로 만드는 방법은 4가지
    - 2 + 2 : 2를 1,2,3으로 만드는 방법은 2가지
    - 3 + 1 : 1을 1,2,3으로 만드는 방법은 1가지
    - 4 + 2 + 1 = 7
    - 즉, dy[4] = dy[3] + dy[2]+ dy[1] = 7
- 결국 dy[i] = dy[i-1] + dy[i-2] + dy[i-3]이라는 점화식이 세워진다.
- 백준에서의 시간은 4ms 차이로 DP가 빨랐지만 큰 차이는 없는듯하다.