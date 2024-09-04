import java.util.ArrayList;

public class Practice2 {
    public static void solution(int n) {
        int A = 1; // Answer의 포인터
        int E = 1; // Expectation의 포인터

        ArrayList result = new ArrayList();
        while (true) {

            // 실제 무게 제곱 - 예상 무게 제곱
            int diff = A * A - E * E;
            if (A - E == 1 && diff > n) {
                break;
            }

            // 두 수의 차가 작으면 A++
            if (diff < n) {
                A++;
            } else { // 두 수의 차가 크면 E++
                E++;
            }

            // 정답이 될 수 있는 case list 에 추가
            if (diff == n) {
                result.add(A);
            }
        }

        if (result.size() != 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(15);
    }
}
