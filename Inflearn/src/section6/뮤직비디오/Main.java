package section6.뮤직비디오;

import java.util.Arrays;
import java.util.Scanner;

//N개의 곡을 M개의 DVD에 담을 때, DVD의 최소 용량 크기
public class Main {
    public int count(int[] songs, int capacity){
        int count = 1, sum = 0;
        for(int i=0; i<songs.length; i++) {
            if(sum+songs[i] <= capacity) sum+= songs[i]; // DVD 용량이 부족할 때까지 넣다가
            else { // i번째 노래를 넣음으로써 DVD 용량이 초과된다면
                count++; // DVD 개수를 하나 증가시키고
                sum=songs[i]; // 새로운 DVD에 노래를 넣는다.
            }
        }
        return count;
    }
    public int solution(int n, int m, int[] songs){
        int answer = 0;

        int lt = Arrays.stream(songs).max().getAsInt(); // lt는 배열의 최대값, stream() 사용해서 배열 최대값 편하게 구하는 방법
        int rt = Arrays.stream(songs).sum(); // rt는 배열 원소 총합, stream()이 내부 반복자를 쓰기 때문에 for문보다 낫다.

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = count(songs,mid);

            if (cnt <= m) { // 문제 조건 만족할 경우(DVD를 m개 쓰고 모든 노래를 다 넣을 수 있는 경우)
                rt = mid-1; // 문제 조건은 만족했지만 '최소값'을 찾기 위해 위해 이어서 탐색
                answer = mid;
            }
            else lt = mid+1; // m개의 DVD만으로 모든 노래를 다 넣을 수 없는 경우(용량을 늘림으로써 DVD 개수를 줄여야 됨)
        }
        return answer;
    }

    public static void main(String[] args) {
        Main a = new Main();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m =sc.nextInt();
        int[] songs = new int[n];
        for(int i=0; i<n; i++)
            songs[i] = sc.nextInt();
        System.out.println(a.solution(n,m,songs));
    }
}
