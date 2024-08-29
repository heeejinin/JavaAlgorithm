// Practice1
// 해시 테이블 배열로 직접 구현

class MyHashTable {
    Integer[] table;
    int elemCnt;

    MyHashTable() {
    }

    // 해시 테이블 생성
    MyHashTable(int size) {
        this.table = new Integer[size];
        this.elemCnt = 0;
    }

    // 해시 함수
    public int getHash(int key) {
        return key % this.table.length;
    }

    // 데이터 저장
    public void setValue(int key, int data) {
        int idx = this.getHash(key);
        this.table[idx] = data;
        this.elemCnt++;
    }

    // 데이터 꺼내기
    public int getValue(int key) {
        int idx = this.getHash(key);
        return this.table[idx];
    }

    // 데이터 지우기
    public void removeValue(int key) {
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elemCnt--;
    }

    // 해시테이블 출력
    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i + ": " + this.table[i]);
        }
    }
}

public class Practice1 {

    public static void main(String[] args) {
        // Test code
        MyHashTable ht = new MyHashTable(7);
        ht.setValue(1, 1);
        ht.setValue(2, 2);
        ht.setValue(3, 3);
        ht.setValue(4, 4);
        ht.setValue(5, 5);
        ht.printHashTable();
        ht.setValue(8, 6);
        ht.printHashTable();
    }
}
