#올바른 괄호

## 문제
```
설명   
    괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
    
    (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


입력
    첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


출력
    첫 번째 줄에 YES, NO를 출력한다.
```
```
예시 입력 1 
(()(()))(()

예시 출력 1
NO
```
**첫 번째 풀이방법**
- for 문을 통해 괄호들을 넣으면서 i-1번째 인덱스가 '(', i번째 인덱스가 ')', 즉 괄호가 완성되면 stack에서 2개의 원소를 pop한다.
- 이렇게 for문이 다 돌았을 때, stack이 비어있지 않다면(isEmpty 메소드 사용) "NO"를 return 하고, 비어있다면 "YES"를 return

Code
```java
public String solution(String s) {
    String answer = "NO";
    Stack<Character> stack = new Stack<Character>();
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
        stack.push(s.charAt(i));
        if (cnt >= 1) {
            if (stack.elementAt(cnt-1) == '(' && stack.elementAt(cnt) == ')') {
                stack.pop();
                stack.pop();
                cnt-=2;
            }
        }
        cnt++;
    }
    if (stack.isEmpty()) return "YES";
    return answer;
}
```
**최종 풀이방법**
- 내가 한 방식과 다르게 for문은 돌지만 모든 괄호를 넣지 않고, 열린 괄호만 넣는다.
- 닫힌 괄호일 때는 다음과 같다.
    - 스택이 비어있다면, "NO" return (닫힌 괄호가 더 많은 상황)
    - 스택이 비어있지 않다면, pop(열린 괄호를 만난 것이므로 괄호 완성)
- for문이 끝난 뒤에 stack이 비어있지 않다면 "NO" return(열린 괄호가 더 많은 상황)

**얻어갈 것**
- 괄호가 있다 -> Stack 써야 되는 문제구나~