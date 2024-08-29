// Practice5
// 해시 충돌 해결 - 분리 연결법

class Node {
    int key;
    int data;
    Node next;

    Node() {}
    Node(int key, int data, Node next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {}
    LinkedList(Node node) {
        this.head = node;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int key, int data) {
        if (this.head == null) {
            this.head = new Node(key, data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key, data, null);
        }
    }

    public void removeData(int data) { // 비교는 키 값과 비교함 data X)
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.key == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public Integer findData(int key) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.key == key) {
                return cur.data;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return null;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class MyHashTable5 {
    LinkedList[] table;

    MyHashTable5(int  size) {
        this.table = new LinkedList[size];
        // 각각의 위치에 객체 생성
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedList(null);
        }
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    //데이터 세팅
    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        this.table[idx].addData(key, data);
    }

    //데이터를 얻어오는 부분
    public int getValue(int key) {
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    //데이터 지우는 부분
    public void removeValue(int key) {
        int idx = this.getHash(key);

        this.table[idx].removeData(key);
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print(i + ": ");
            this.table[i].showData();
        }
    }

}

public class Practice5 {
    public static void main(String[] args) {
        // Test code
        MyHashTable5 ht = new MyHashTable5(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();
        ht.setValue(12, 11);
        ht.setValue(23, 12);
        ht.setValue(34, 13);

        ht.setValue(13, 21);
        ht.setValue(24, 22);
        ht.setValue(35, 23);

        ht.setValue(5, 1);
        ht.setValue(16, 2);
        ht.setValue(27, 3);
        ht.printHashTable();

        System.out.println("== key 값으로 해당 데이터 가져오기 ==");
        System.out.println(ht.getValue(1));
        System.out.println(ht.getValue(12));

        System.out.println("== 데이터 삭제 ==");
        ht.removeValue(1);
        ht.removeValue(5);
        ht.removeValue(16);
        ht.printHashTable();

        //출력 결과
        //== Hash Table ==
        //0: List is empty!
        //1: 10
        //2: 20
        //3: 30
        //4: List is empty!
        //5: List is empty!
        //6: List is empty!
        //7: List is empty!
        //8: List is empty!
        //9: List is empty!
        //10: List is empty!
        //== Hash Table ==
        //0: List is empty!
        //1: 10 11 12 13
        //2: 20 21 22 23
        //3: 30
        //4: List is empty!
        //5: 1 2 3
        //6: List is empty!
        //7: List is empty!
        //8: List is empty!
        //9: List is empty!
        //10: List is empty!
        //== key 값으로 해당 데이터 가져오기 ==
        //10
        //11
        //== 데이터 삭제 ==
        //== Hash Table ==
        //0: List is empty!
        //1: 11 12 13
        //2: 20 21 22 23
        //3: 30
        //4: List is empty!
        //5: 3
        //6: List is empty!
        //7: List is empty!
        //8: List is empty!
        //9: List is empty!
        //10: List is empty!
    }
}
