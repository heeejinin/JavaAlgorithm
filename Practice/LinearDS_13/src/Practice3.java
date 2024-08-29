// Practice3
// 참고 - Hashtable? HashMap?

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Practice3 {
    public static void main(String[] args) {
        //Hashtable
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(0, 10);
        System.out.println(ht.get(0)); // 10

        // HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 10);
        System.out.println(hm.get(0)); // 10

        // 두 가지 모두 Map 인터페이스로 구현된 class 이기 때문에
        // 다형성 부분으로 보면 Map 을 이용하여 값을 받아올 수 있음
        Map<Integer, Integer> map1 = ht;
        Map<Integer, Integer> map2 = hm;
        System.out.println(map1.get(0)); // 10
        System.out.println(map2.get(0)); // 10


        // 차이점

        // Hashtable=> key로 null을 이용한 키값을 이용할 수 없음
        ht.put(null, -999);
        System.out.println(ht.get(null)); // 에러 발생
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "key" is null
        //	at java.base/java.util.Hashtable.put(Hashtable.java:481)
        //	at Practice3.main(Practice3.java:30)

        // HashtMap=> key로 null을 이용한 키값을 사용 가능
        hm.put(null, -999);
        System.out.println(hm.get(null)); //-999

        //Hash

    }
}
