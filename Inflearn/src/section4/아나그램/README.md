# 아나그램(해쉬)

## 문제

```
설명
    Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
    
    예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
    
    알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
    
    길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.


입력
    첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
    
    단어의 길이는 100을 넘지 않습니다.


출력
두    단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
```
```
예시 입력 1 
AbaAeCe
baeeACA

예시 출력 1
YES

예시 입력 2 
abaCC
Caaab

예시 출력 2
NO
```
** 첫 번쨰 풀이방법**
- HashMap 2개를 만들어서 입력받은 2개의 String형 파라미터를 각각 넣는다.
- Object.equals() 메소드를 이용하여 두 HashMap이 같은지 판단한다.

Code
```java
public String solution(String s1, String s2){
    String answer = "NO";
    HashMap<Character, Integer> map1 = new HashMap<Character,Integer>();
    HashMap<Character, Integer> map2 = new HashMap<Character,Integer>();
    for(char key : s1.toCharArray())
        map1.put(key, map1.getOrDefault(key,0)+1);
    for(char key : s2.toCharArray())
        map2.put(key, map2.getOrDefault(key,0)+1);
    if(map1.equals(map2))
        answer="YES";
    return answer;
}
```

**다른(최종) 풀이방법**
- HashMap<Character, Integer>를 만들어서 입력받은 2개의 파라미터 중 첫 번쨰 파라미터의 문자별 개수를 입력한다.
- 2번째 파라미터를 넣을 때는 기존 해쉬맵에 있던 Key를 만날 때, Value를 하나씩 줄여간다.
- 이때, 두 번쨰 파라미터가 첫 번째 파라미터와 다르다면 다음과 같이 구분할 수 있다.
    - 가지고 있는 Key가 다를 때 : containsKey() 함수를 통해 구분
    - 같은 Key를 가지고 있지만, Value가 다를 때 : value를 줄여가다보면 하나의 key는 0보다 작은 value를 갖게 된다. 
      이를 통해 value가 다름을 구분할 수 있다.

**얻어갈 것**
- HashMap을 2개 만들어서 비교하지 않고, HashMap.put() 메소드를 통해 value를 줄여나가며 비교할 수도 있다.

