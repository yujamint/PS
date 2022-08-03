package section1;

import java.util.Scanner;
//공부할 것 : StringBuilder, StringBuffer
public class Wordflipover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] array = new String[n];
        String[] reversedArray = new String[n];

        for(int i=0; i<n; i++){
            String str = sc.next();
            array[i]=str;
        }
        //단어 뒤집는 방법
        //1.StringBuffer의 reverse()
        //2.Character 형으로 바꿔서 for문으로 하나씩 바꾸기
        //3.ArrayList의 reverse(list) 통해서 뒤집기
        for(int i=0; i<n; i++){
            StringBuffer sb = new StringBuffer(array[i]);
            reversedArray[i] = sb.reverse().toString();
        }

        for(int i=0; i<n; i++)
            System.out.println(reversedArray[i]);
    }
}
