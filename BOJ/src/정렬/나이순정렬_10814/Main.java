package 정렬.나이순정렬_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
    int age;
    String name;
    int personNum;

    static int autoNum = 1;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        this.personNum = autoNum++;
    }

    @Override
    public int compareTo(Person o) {
        if (age == o.age) return personNum - o.personNum;
        return age - o.age;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(age, name);
        }

        Arrays.sort(arr);

        for (Person p : arr) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }

        System.out.println(sb);
    }
}
