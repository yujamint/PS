// 배달해야 되는 가장 먼 곳(del), 수거해야 되는 가장 먼 곳 체크(back)
// 0 되면 갱신
// del까지 가고, back까지 가고, home으로

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        list.remove(Integer.valueOf(3));
        list.remove(Integer.valueOf(1));

        System.out.println(list.get(0));


    }
}