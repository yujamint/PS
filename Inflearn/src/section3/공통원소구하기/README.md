# 공통원소 구하기

## 문제
```
설명
    A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


입력
    첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
    
    두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    
    세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
    
    네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    
    각 집합의 원소는 1,000,000,000이하의 자연수입니다.


출력
    두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
```
```
예시 입력 1 
5
1 3 9 5 2
5
3 2 5 7 8

예시 출력 1
2 3 5
```

**첫 번째 풀이방법**
- 입력 받은 두 배열을 하나의 ArrayList(temp)에 합친다.
- 2중 for문을 통해 중복되는 원소를 찾아내서, ArrayList(answer)에 추가한다.
- **시간초과(1000ms)로 인해 실패**

Code
```java
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i : arr1)
            temp.add(i);
        for (int i : arr2)
            temp.add(i);
        for(int i=0; i<temp.size(); i++){
            for(int j=i+1; j<temp.size(); j++){
                if(temp.get(j).equals(temp.get(i))) {
                    answer.add(temp.get(j));
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
```

**두 번쨰 풀이방법(Two Pointers 알고리즘 적용)**
- 입력 받은 두 배열 a,b를 오름차순으로 정렬한다.
- a,b 각각에 대한 포인터를 두고 포인터가 가리키는 원소를 대소비교한다.
- 작은 값을 가리키고 있는 배열의 포인터를 증가시키며 반복하다가, 같은 값을 가질 경우에 answer에 넣는다.
- **시간초과로 인해 실패** - 정렬에서 문제가 있는 거 같다. -> Arrays.sort() 함수로 정렬했더니 정답

**공부할 내용**
- 중복된 원소를 찾는 다른 방법 // 내가 푼 방법은 뭔가.. 구려보인다.
- 배열 정렬부터 다시 배우자 // 강의에서는 Arrays.sort() 썼음
