// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;

public class Main {
    
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int l = left;
        int r = mid + 1;
        int idx = l;

        while (l <= mid || r <= right) {
            if (l <= mid && r <= right) {
                if (arr[l] <= arr[r]) {
                    tmp[idx++] = arr[l++];
                } else {
                    tmp[idx++] = arr[r++];
                }
            } else if (l <= mid && r > right) {
                tmp[idx++] = arr[l++];
            } else {
                tmp[idx++] = arr[r++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
