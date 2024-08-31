// Practice 1
// 자바 기본 PriorityQueue 응용
// 나이 순으로 오름차순 또는 내림차순 출력


import java.util.PriorityQueue;

// 에러 발생 Person cannot be cast to class java.lang.Comparable
class Person { // 인터페이스 상속 없이 구현
    // Comparable 인터페이스 사용
//class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Person o) {
//        // 1: 변경 안함
//        // -1: 변경
//
//        // 새롭게 추가하는 데이터가 더 적을 때 변경 (적은 값이 위로 올라감, 오름차순)
////        return this.age >= o.age ? 1 : -1;
//        //== 실제 출력 순서 ==
//        //            //B 20
//        //            //A 30
//        //            //E 35
//        //            //C 45
//        //            //D 62
//
//        // 새롭게 추가하는 데이커가 더 클 때 변경 (큰 값이 위로 올라감, 내림차순)
//        return this.age >= o.age ? -1 : 1;
//        //== 실제 출력 순서 ==
//        //D 62
//        //C 45
//        //E 35
//        //A 30
//        //B 20
//    }
}

public class Practice1 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person> pq = new PriorityQueue<>();

//        for (int i = 0; i < name.length; i++) {
//            pq.offer(new Person(name[i], age[i]));
//        }
//
//        System.out.println("== 실제 출력 순서 ==");
//        while (!pq.isEmpty()) {
//            Person p = pq.poll();
//            System.out.println(p.name + " " + p.age);
//
//        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        PriorityQueue<Person> pq2 = new PriorityQueue<>(// 람다식으로 객체 생성
                (Person p1, Person p2) -> p1.age >= p2.age ? 1 : -1); // 오름차순
//                (Person p1, Person p2) -> p1.age >= p2.age ? -1 : 1); // 내림차순
        for (int i = 0; i < name.length; i++) {
            pq2.offer(new Person(name[i], age[i]));
        }

        while (!pq2.isEmpty()) {
            Person p = pq2.poll();
            System.out.println(p.name + " " + p.age);
        }
    }
}
