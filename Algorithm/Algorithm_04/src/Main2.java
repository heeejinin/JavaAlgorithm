// 자바 기본 binarySearch

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("== 데이커가 있는 경우 ==");
        System.out.println(Arrays.binarySearch(arr,1)); // 0
        System.out.println(Arrays.binarySearch(arr,10)); // 3
        System.out.println(Arrays.binarySearch(arr,30)); // 5


        System.out.println("== 데이커가 없는 경우 ==");
        // => 없는 값 3이 만약 배열에 있었다면 2번 인덱스임 => 2의 부호를 바꾸고 -1을 한 값을 출력하게 됨
        System.out.println(Arrays.binarySearch(arr,3)); // -3
        System.out.println(Arrays.binarySearch(arr,11)); // -5
        System.out.println(Arrays.binarySearch(arr,35)); // -7
    }
}
