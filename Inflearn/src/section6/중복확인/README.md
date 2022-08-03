# 중복 확인

## 문제
```
[설명]
현수네 반에는 N명의 학생들이 있습니다.

선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.

만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,

N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.


[입력]
첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.

두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
```
```
[출력]
첫 번째 줄에 D 또는 U를 출력한다.


예시 입력 1 
8
20 25 52 30 39 33 43 33

예시 출력 1
D
```
**첫 번째 풀이방법**
- 2중 for문을 통해 중복되는 숫자가 있는지 확인한다.
- 가장 무식하고 단순한 방법이지 않나..

Code
```java
public char solution(int n, int[] arr){
    char answer = 'U';
    for(int i=0; i<n-1; i++){
        for(int j=i+1; j<n; j++){
            if(arr[i] == arr[j]) return 'D';
        }
    }
    return answer;
}
```

**두 번째 풀이방법**
- HashMap을 이용하여 Value가 1이 아닌 원소를 찾으면 시간복잡도 O(n)으로 문제를 해결할 수 있다.
- 가장 빠르게 푸는 방법이지 않을까 싶다.

Code
```java
public char solution(int n, int[] arr){
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int x : arr) hm.put(x,hm.getOrDefault(x,0) + 1);
    for (Map.Entry<Integer,Integer> entry : hm.entrySet())
        if(entry.getValue() != 1) return 'D';
    return 'U';
}
```

**세 번째 풀이방법(정렬 이용)**
- 삽입정렬의 과정 중에, 삽입하려는 숫자를 앞의 정렬된 부분과 비교해가며 삽입할 위치를 찾는 과정이 있다.
- 이 과정을 이용해서 삽입하려는 숫자와 같은 숫자가 있다면 'D'를 리턴한다.
- 정렬이 끝날 때까지 같은 숫자가 없다면 'U' 리턴
- 강의에서는 Arrays.sort() 함수를 사용해 정렬을 마친 뒤에 for문에서 i번째와 i+1번째가 같은 숫자인지 비교

**얻어갈 것**
- 중복이 있는지 유무를 찾을 때는 HashMap이 가장 빠른 방법이다.
- 정렬을 이용해서도 중복 검사가 가능하다.