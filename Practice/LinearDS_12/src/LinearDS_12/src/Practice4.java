// Practice4
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

class MyHashTable4 extends MyHashTable {
    int c;

    MyHashTable4(int size) {
        super(size);
        this.c = this.getHashC(size);
    }

    // 해시테이블 사이즈보다 조금 작은 사이즈
    public int getHashC(int size) {
        int c = 0;

        if (size <= 2) { //소수니까 바로 return
            return size;
        }

        for (int i = size - 1; i > 2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                c = i;
                break;
            }
        }
        return c;
    }

    // 두 번째 충돌난 해시
    public int getHash2(int key) {
        int hash = 1 + key % this.c;
        return hash;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        //full체크
        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is full!");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else { //충돌 난 지점
            int newIdx = idx;
            int cnt = 1;
            while (true) {
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
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
public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();


        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();

        //출력 결과
        //== Hash Table ==
        //0: null
        //1: 10
        //2: 20
        //3: 30
        //4: null
        //5: null
        //6: null
        //7: null
        //8: null
        //9: null
        //10: null
        //== Hash Table ==
        //0: 100
        //1: 10
        //2: 20
        //3: 30
        //4: null
        //5: null
        //6: null
        //7: 300
        //8: 200
        //9: null
        //10: null
    }
}
