# Least Recently Used

## 문제

```
[설명]
캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가

필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.

철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.

LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.

캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
```
![image1](https://cote.inflearn.com/public/upload/c366c701c2.jpg)
```
캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후

캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.


[입력]
첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.

두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.


[출력]
마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
```
```
예시 입력 1 
5 9
1 2 3 2 6 2 3 5 7

예시 출력 1
7 5 3 2 6
```
**힌트**
![image2](https://cote.inflearn.com/public/upload/3fe5828362.jpg)


**첫 번째 풀이방법**
- 해당 문제는 Cache Miss가 발생했을 때와, Cache Hit이 발생했을 때를 나누어서 풀어봤다.
  - Cache Miss 발생
    - 배열이 꽉 차 있지 않을 때 : 배열에 바로 추가한다.
    - 배열이 꽉 차 있을 때 : 가장 오래 전에 추가한 숫자를 지우고 새로운 숫자를 추가한다.
  - Cache Hit 발생 : Cache Hit이 발생한 원소의 인덱스를 찾은 뒤, 가장 최신에 넣은 숫자부터 Hit이 발생한 인덱스의 바로 앞 인덱스까지 한 칸 뒤로 미룬 뒤에 hit이 발생한 인덱스를 가장 앞에 넣는다.
- 첫 번째 풀이에서는 ArrayList를 사용했는데, 기술면접을 본다거나 할 때 ArrayList를 사용할 수도 없고, 배열로 직접 구현하는 게 좋다고 선생님께서 말씀하셔서 배열로 다시 구현을 해볼 예정이다.

Code
```java
public ArrayList<Integer> solution(int s, int n, int[] arr){
    ArrayList<Integer> answer = new ArrayList<>(s);
    for(int i=0; i<n; i++){
        if(!answer.contains(arr[i])){ // Cache Miss 일 때
            if(answer.size() != s) answer.add(arr[i]); // 캐시가 꽉 차 있지 않을 때
            else { // 캐시가 꽉 차 있을 때
                answer.remove(0);
                answer.add(arr[i]);
            }
        }
        else{ // Cache Hit 일 때
            int index = answer.indexOf(arr[i]);
            for(int j=index; j<answer.size()-1; j++){
                answer.set(j, answer.get(j+1));
            }
            answer.set(answer.size()-1, arr[i]);
        }
    }
    for(int i=0; i<answer.size()/2; i++)
        Collections.swap(answer,i,s-i-1);
    return answer;
}
```

**두 번째(최종) 풀이방법**
- for 문을 통해 해야할 작업이 캐시에 있는지 확인한다.
  - 만약 캐시에 있다면, 해당 index를 저장한다.
- 캐시에 작업이 없다면(Cache Miss), 기존에 있던 작업을 한 칸씩 뒤로 미룬다.
- 캐시에 작업이 있다면(Cache Hit), 가장 최근에 한 작업부터 첫 번째 과정에서 찾은 인덱스 전까지 한 칸씩 뒤로 미룬다.
- 마지막으로, 해야할 작업을 배열에 추가해준 뒤 위 과정을 반복한다.
