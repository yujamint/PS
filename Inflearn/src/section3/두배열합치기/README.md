# 두 배열 합치기

## 문제
```
설명
 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


입력
 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 
 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 
 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 
 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 
 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


출력
 오름차순으로 정렬된 배열을 출력합니다.
```
```
예시 입력 1 
3
1 3 5
5
2 3 6 7 9

예시 출력 1
1 2 3 3 5 6 7 9
```

**첫 번째 풀이방법**
- 입력 받은 두 개의 배열을 for문을 통해 하나의 ArrayList에 넣는다.
- Collections.sort() 메소드를 이용해 오름차순으로 정렬한다.

코드
```java
public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>(n+m);
        for (int i : arr1)
            answer.add(i);
        for (int i : arr2)
            answer.add(i);
        Collections.sort(answer);
        return answer;
```


**두 번째(최종) 풀이방법(Two Pointers 알고리즘 적용)**
1. 입력받은 배열 두 개(a와 b)에 각각 위치 포인터를 둔다.
2. a의 포인터가 가리키고 있는 원소와 b의 포인터가 가리키고 있는 원소를 대소비교한다.
3. 오름차순 정렬이기 때문에 비교했을 때 작은 값을 한 배열에 넣으면서, 포인터를 이동한다.



**공부할 내용**

1. 첫 번째 풀이를 할 때, 메소드를 이용하기 편한 ArrayList를 사용했는데, 배열에서 ArrayList로 옮기는 과정에서의 cost가 큰가?
2. 두 번째 풀이방법 숙지