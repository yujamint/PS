# 결혼식

## 문제
```
[설명]
현수는 다음 달에 결혼을 합니다.

현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.

피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.

각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.

현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.

만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.


[입력]
첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.

두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.

시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.


[출력]
첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.
```
```
예시 입력 1 
5
14 18
12 15
15 20
20 30
5 14

예시 출력 1
2
```

**첫 번째 풀이방법**
- 친구들이 오는 시간과 떠나는 시간을 변수로 갖는 Time 클래스를 생성한다.
    - 오는 시간을 오름차순으로 정렬 / 오는 시간이 같다면 떠나는 시간으로 내림차순 정렬
- 시간대별로 접근하기 위해 Queue를 생성해서, Time 객체를 다음과 같이 넣는다.
  - 새로 큐에 넣게 될 친구가 오는 시간이
    - 큐 최상단에 위치한 친구가 떠나는 시간보다 이르게 온다면 큐에 추가한다.
    - 큐 최상단에 위치한 친구가 떠나는 시간보다 늦게 온다면 해당 시간에 연회장에 머물러 있는 친구들만 남을 때까지 큐에서 빼낸다.
        - 연회장에 남아있는 친구들만 큐에 남아있게 된다면, 큐에 넣는다.
- 큐의 사이즈가 같은 시간대에 남아있는 친구들의 수이므로, 친구 한 명을 넣을 때마다 최대값을 갱신해가며 답을 구한다.
- **이 방법으로 해결하지 못함**

Code
```java
import java.util.*;

class Time implements Comparable<Time>{
    int c,g;
    public Time(int c, int g){
        this.c = c;
        this.g = g;
    }
    @Override
    public int compareTo(Time o){
        if(this.c == o.c) return o.g - this.g;
        return this.c - o.c;
    }
}

public class Main {
    public int solution(int n, ArrayList<Time> list) {
        Collections.sort(list);
        int answer = 0;
        int et = Integer.MAX_VALUE;
        Queue<Time> Q = new LinkedList<>();
        for (Time ob : list){
            if(ob.c < et) Q.offer(ob);
            else {
                while(!Q.isEmpty() && Q.peek().g <= ob.c) Q.poll();
                Q.offer(ob);
            }
            et = Q.peek().g;
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>(n);
        for (int i=0; i<n; i++){
            int come = sc.nextInt();
            int go = sc.nextInt();
            list.add(new Time(come, go));
        }
        System.out.println(T.solution(n,list));
    }
}
```

**강의 풀이방법**
- Time 클래스를 생성할 때, 오는 시간과 떠나는 시간을 속성으로 가지지 않고, 시간과 오는지,가는지의 상태를 속성으로 갖는다
    - ex) 14 's' -> 14시에 온 것 // 18 'e' -> 18시에 떠난 것
- Time 클래스를 정렬할 때, 시간을 기준으로 오름차순 정렬하고 시간이 같을 경우 상태(state)를 기준으로 오름차순 정렬한다.
    - 14시에 떠나는 사람과 14시에 오는 사람이 있다고 쳤을 때, 14시에 떠나는 사람은 14시에 피로연에 존재하지 않는 것이므로, 떠나는 경우를 우선적으로 처리해야 된다. -> 상태를 내림차순 정렬하게 되면 알파벳 순으로 정렬되므로 떠나는 것을 의미하는 'e' 가 먼저 나오게 된다.
- Time 객체를 저장해놓은 list를 순차적으로 꺼내면서 친구가 피로연에 왔을 때, 즉 Time.s == 's' 일 때는 cnt++ / 피로연을 떠났을 때, 즉 Time.s == 'e'일 때는 cnt--
    - cnt는 한 시간대에 머물러있는 친구가 몇 명인지를 의미한다.
- cnt를 통해 동시간대에 머물 수 있는 최대 손님 수를 갱신한다.

**얻어갈 것**
- 상태를 Time 클래스의 속성으로 가짐으로써 시간의 흐름을 반영할 수 있다.