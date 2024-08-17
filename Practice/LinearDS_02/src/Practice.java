// Practice
// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

class MyArray {

    int[] arr;

    //  배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }

    //  배열에 데이터 삽입
    public void insertData(int index, int data) {
        // 예외 처리
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }

        int[] arrDup = this.arr.clone();
        //데이터가 하나 입력 될 것이기 때문에 길이 +1 해줌
        this.arr = new int[this.arr.length + 1];

        //데이터 추가하려는 위치까지는 기존의 데이터 할당
        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }

        //데이터를 추가하려는 위치 다음도 기존의 데이터로 할당
        for (int i = index; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }


    //  배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1; // 처음엔 아무것도 찾은게 없다는 의미로 -1

        //기존에 데이터에 삭제할 데이터 있는지 확인
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == data) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else { //삭제할 데이터가 있는 경우
            // 기존 데이터 일단 백업
            int[] arrDup = this.arr.clone();

            // 데이터가 삭제되면 배열 길이 줄어드니까 줄어든 길이로 새로 생성
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }

            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }

}

public class Practice {
    public static void main(String[] args) {

//      Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5]

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60]

        myArray.insertData(-1, 0);  // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60]

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60]

        myArray.removeData(99); // 해당 데이터가 없습니다.
    }
}
