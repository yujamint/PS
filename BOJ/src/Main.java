// 배달해야 되는 가장 먼 곳(del), 수거해야 되는 가장 먼 곳 체크(back)
// 0 되면 갱신
// del까지 가고, back까지 가고, home으로

import java.util.*;

public class Main {
    public static Integer[] solution(Integer[] stuffArr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < stuffArr.length; i++) {
            String str = stuffArr[i].toString();
            if (!str.contains("000")) list.add(stuffArr[i]);
        }

        Integer[] answer = list.toArray(new Integer[0]);
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        ArrayList<String[]> ans = new ArrayList<>();
//        ans.add(new String[]{});
        ans.add(new String[]{"eggroll"});
        ans.add(new String[]{"kimchi"});
        ans.add(new String[]{"fishSoup"});
        ans.add(new String[]{"eggroll", "kimchi"});
        ans.add(new String[]{"eggroll", "fishSoup"});
        ans.add(new String[]{"kimchi", "fishSoup"});
        ans.add(new String[]{"eggroll", "kimchi", "fishSoup"});

        Collections.sort(ans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Arrays.toString(o1).compareTo(Arrays.toString(o2));
            }
        });

        for (String[] strs : ans) {
            for (String str : strs) {
                System.out.print(str + " ");
            }
            System.out.println("");
        }
    }
}

/*
1. Integer[] stuffArr 이 주어짐
ex)[1, 10, 11000, 1111]
- 요소는 0과 1로만 이루어진 숫자, 항상 1로만 시작
- 요소는 중복되지 않음
- 요소의 길이는 20이하
- 배열의 길이는 2이상 10 이하

2.  이 stuffArr의 요소중에서 숫자 0이 3개 이상 나오면 배열에서 제외해야됨

3. 제외할거 제외하고 남은 배열을 오름차순으로 정렬, Integer[] 타입으로 리턴하기
 */