# 피보나치 재귀(메모이제이션)

## 문제
```
[설명]
1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


[입력]
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


[출력]
첫 줄에 피보나치 수열을 출력합니다.
```
```
입력예제 1
10

출력예제 1
1 1 2 3 5 8 13 21 34 55
```

**풀이방법**
- n의 첫 번째, 두 번째 항은 1로 정해져있으므로 n <= 2 일 때, 1을 리턴하고, 그 외에는 n-2번째 항과 n-1번째 항을 더한 값을 리턴하며 재귀함수를 호출한다.
- 이 방법의 경우, 이미 한 번 계산했던 값들이 계속해서 나오기 때문에 매우 느리다.

Code
```java
public int DFS(int n){
    if (n<=2) return 1;
    else return DFS(n-1) + DFS(n-2);
}
```

이를 해결하기 위해 static한 int 배열을 만들어서 한 번 계산한 값을 배열에 저장한다.

Code
```java
public class Main {
    static int[] fibo;
    public int DFS(int n){
        if (n<=2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        T.DFS(n);
        for (int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
```
하지만, 이 방법 또한 n=45일 때, 실행하는 데에 약 7초의 시간이 걸리는 것을 확인하였고, 개선의 여지가 있다.
- 메모이제이션 사용
```java
if(fibo[n]>0) return fibo[n];
```
해당 코드를 DFS 함수 제일 상단에 작성한다. 이는 fibo에 이미 기록된 값이 있다면 그 값을 사용하겠다는 의미를 가진다. 즉, 처음에 계산을 한 뒤에 이를 기록해놓고 사용해가며 이미 구한 값을 또 구하게 되는 재귀함수의 단점을 개선하는 것이다.
이를 통해 n이 커지면 커질수록 재귀함수 호출 횟수를 크게 줄일 수 있고, 결과적으로 시간복잡도가 크게 줄어든다. 

**얻어갈 것**
- 재귀는 스택프레임이 쌓이며 메모리도 많이 낭비되기 때문에 성능면에서는 배열과 for문을 이용해서 푸는 것이 더 좋다.