// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
class Node {
    int data; //데이터
    Node next; //링크

    // 생성자
    Node() {
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class LinkedList { // 자바의 경우 메모리를 자동적으로 정리하기 때문에 링크 부분만 잘 관리하면 됨
    Node head;

    LinkedList() {
    }

    LinkedList(Node node) {
        this.head = node;
    }

    //  연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    //  연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) { // 마지막에 위치한 노드를 찾는 과정
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    //  연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head; // 삭제할 데이터 변수
        Node prev = cur; // 삭제 후 링크를 수정해줄 변수

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    //  연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
    }

    //  연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
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


public class Main {

    public static void main(String[] args) {

//      Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();      // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();      // 1 2 3 4 5

        myList.findData(3);     // Data exist!
        myList.findData(100);   // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();      // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData();    // List is empty

    }

}
