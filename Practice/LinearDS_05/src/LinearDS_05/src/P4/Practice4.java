
// Practice4
// 연결 리스트 배열 사용 연습

// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오.
// 관리 규칙은 다음과 같다.
// 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기
package P4;

import java.util.HashSet;

class Node {
    String data;
    Node next;

    Node() {
    }

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    char alphabet; //첫 글자 관리를 위해 char 변수 잡아줌

    LinkedList() {
    }

    LinkedList(Node node, char alphabet) {
        this.head = node;
        this.alphabet = alphabet;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(String data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data.equals(data)) {
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

    public boolean findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return false;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data.equals(data)) {
                System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return false;
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

public class Practice4 {

    public static void dataCollect(String[] data) {
        //배열 중 첫 글자를 솎아내는 작업
        HashSet<Character> set = new HashSet<>();

        for (String item : data) {
            set.add(item.toCharArray()[0]); // for문을 돌면서 첫 글자들 모아짐 (HashSet 중복 제거)
        }
        System.out.println(set);

        //Character 값을 담기 위한 Array
        Character[] arr = set.toArray(new Character[0]);
        //연결 리스트 생성 시 접근이 불가한 상태이고 for문을 돌면서 해당 위치에 객체 생성을 해줘야 함
        LinkedList[] linkedList = new LinkedList[set.size()];
        for (int i = 0; i < linkedList.length; i++) {
            //각각의 위치에 객체 생성
            //head는 null, 각 위치엔 알파벳 첫 글자가 담기도록
            linkedList[i] = new LinkedList(null, arr[i]);
        }

        //연결 리스트 연결
        for (String item : data) {
            for (LinkedList list : linkedList) {
                //list의 알파벳과 각각의 문자열 첫글자가 같으면 그 리스트에 addData()
                if (list.alphabet == item.toCharArray()[0]) {
                    list.addData(item);
                }
            }
        }

        for (LinkedList list : linkedList) {
            System.out.print
                    (list.alphabet + " : ");
            list.showData();
        }

    }

    public static void main(String[] args) {
        // Test code
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry", "cherry", "orange"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab", "kitten", "anaconda", "chicken"};
        dataCollect(input2);

    }
}
