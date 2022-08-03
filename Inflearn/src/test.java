import java.util.Arrays;

public class test {

    void binarySearch() {
        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        int m = 32; // 배열에서 32를 찾는다.
        int index = -1; // 정렬 후 m의 인덱스 번호

        Arrays.sort(arr); // 이진 탐색 실행하기에 앞서 배열 오름차순 정렬

        int low = 0, high = arr.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == m) { // m을 찾았을 떄
                index = mid;
                break;
            }
            else if (arr[mid] < m) // mid 인덱스의 원소가 m보다 작을 때
                low = mid + 1;
            else // mid 인덱스의 원소가 m보다 클 때
                high = mid - 1;
        }
        System.out.println(index); // 2 출력
    }

    public static void main(String[] args){
        while (true) System.out.println(1);
    }
}
