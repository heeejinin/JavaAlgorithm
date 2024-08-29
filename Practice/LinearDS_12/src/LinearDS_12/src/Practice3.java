// Practice3
// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHashTable3 extends MyHashTable {

    MyHashTable3(int size) {
        super(size);
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {//가득 찬 상황
            System.out.println("Hash table is full!");
            return;
        } else if (this.table[idx] == null) { //데이터 넣을 수 있는 상황
            this.table[idx] = data;
        } else {//충돌 난 상황 => 제곱 탐사법
            int newIdx = idx; //충돌난 지점으로 초기화
            int cnt = 0; //충돌 횟수 카운트
            while (true) { //반복문을 돌면서 연산 **Math.pow(2, cnt) => 2의 cnt(충돌횟수)승 제곱셈
                newIdx = (newIdx + (int)Math.pow(2, cnt)) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }

        elemCnt++;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();

        //출력 결과
        //== Hash Table ==
        //0: null
        //1: 10
        //2: 20
        //3: null
        //4: 40
        //5: null
        //6: null
        //7: null
        //8: null
        //9: null
        //10: null
        //== Hash Table ==
        //0: null
        //1: 10
        //2: 20
        //3: null
        //4: 40
        //5: null
        //6: null
        //7: null
        //8: 100
        //9: null
        //10: null
        //== Hash Table ==
        //0: null
        //1: 10
        //2: 20
        //3: null
        //4: 40
        //5: 200
        //6: null
        //7: null
        //8: 100
        //9: 400
        //10: 300
    }
}
