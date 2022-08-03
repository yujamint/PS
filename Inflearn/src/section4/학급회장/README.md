# 학급 회장(해쉬)

## 문제
```
설명
    학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
    
    투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
    
    선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
    
    반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.


입력
    첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
    
    두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.


출력
    학급 회장으로 선택된 기호를 출력합니다.
```
```
예시 입력 1 
15
BACBACCACCBDEDE

예시 출력 1
C
```

**첫 번쨰 풀이방법**
- 입력받은 투표 용지를 String.toCharArray() 메소드를 통해 char 배열로 만든다.
- 후보자 5명을 원소로 갖는 char 배열을 만든다.
- 위에서 만든 두 char 배열을 2중 for문을 통해 비교해가면서 투표 횟수만큼 cnt를 올리고 max(현재 가장 많이 투표를 받은 후보자)보다 높으면 max를 갱신한다.
- **후보자와 투표자의 크기가 커진다면 쓰기 힘든 방법일 것이다.**

Code
```java
public char solution(int n, String str){
    char answer = 0;
    char[] chs = str.toCharArray();
    char[] candidates = new char[]{'A', 'B', 'C' ,'D', 'E'};
    int max = 0;
    for (int i=0; i<5;i++){
        int cnt = 0;
        for(int j=0; j<n; j++)
            if (candidates[i] == chs[j]) cnt++;
        if(max < cnt) {
            max = cnt;
            answer = candidates[i];
        }
    }
    return answer;
}
```

**다른(최종) 풀이방법(HashMap 이용)**
- 원소를 Key와 Value를 쌍으로 갖는 HashMap 자료구조를 이용하여 후보자마다 투표를 얼마나 받았는지 Value를 통해 확인

**공부할 내용**
- HashMap 자료구조 + 메소드
- getOrDefault() key에 따른 Value (없다면 default 값으로)
- keySet() key 배열
- containsKey() 특정 키 포함 여부
- size() 키 개수
- remove() 특정 키 삭제
