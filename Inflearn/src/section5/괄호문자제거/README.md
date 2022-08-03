# 괄호문자제거

## 문제
```java
설명
    입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.


입력
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


출력
    남은 문자만 출력한다.
```
```
예시 입력 1
(A(BC)D)EF(G(H)(IJ)K)LM(N)
        
예시 출력 1
EFLM
```

**첫 번째 풀이방법**
- for 문을 통해 입력 받은 string을 한 문자씩 돌린다.
- 열린 괄호일 때, cnt를 증가시키고, 닫힌 괄호일 때, cnt를 감소시킨다.
  - cnt가 1이라면, 열린 괄호 안에 있는 문자라는 뜻
  - 닫힌 괄호를 만나면 cnt가 감소되면서 0이 된다.-> 괄호를 벗어났다
- '(', ')' 외의 문자를 만났고, cnt가 0일 때는 stack에 push
  - cnt가 0이 아닐 때는 괄호 안에 있으므로 push하지 않는다.

Code
```java
public String solution(String s){
    String answer = "";
    Stack<Character> stack = new Stack<>();
    int cnt = 0;
    for(char x : s.toCharArray()){
        if(x == '(') cnt++;
        else if(x == ')') cnt--;
        else
            if(cnt==0) stack.push(x);
    }
    for(char x : stack)
        answer+=x;
    return answer;
}
```

**최종 풀이방법**
- for 문을 돌며 닫힌 괄호를 만날 때까지 모든 문자를 stack에 push한다.
- 닫힌 괄호를 만나면 최상단의 열린 괄호를 만날 때까지 pop한다.(stack.pop() 메소드가 꺼낸 객체를 return 한다는 것을 이용)
- for 문이 끝나면 괄호 안에 있지 않던 문자만 남게 된다.

**공부할 내용**
- Stack 자료구조
- stack.pop() 메소드는 꺼낸 객체를 리턴한다.
- stack.get()
- stack.size()