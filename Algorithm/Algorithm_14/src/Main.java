// 알고리즘 - 백트래킹

public class Main {

    static int n = 4;
    static int[] board = new int[n]; //Queen을 몇 번째 열에 뒀는지 check
    static int cnt;

    public static int nQueen(int row) {
        // 정상적으로 다 놓은 경우
        if (row == n) { // Queen을 놓을 상황이 됨
            cnt++;
            // 체스판 상에 어떻게 놓였는지 출력
            for (int i = 0; i < n; i++) {
                System.out.print(board[i]+" ");
            }
            System.out.println();
            return cnt;
        }


        // 현재 행에 몇 번째 열에 Queen을 둘 것인지 기록 & 재귀함수가 이뤄질 것임
        // 각 행 각 열에 퀸을 놓으면서 가능성 검사
        for (int i = 0; i < n; i++) {
            // row 행에 i 열에 퀸 위치시킴 (1차원 배열로 열의 번호를 기록)
            board[row] = i;

            // promising 유망한지 유무 check
            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }


        return cnt;
    }

    // 같은 행인 경우를 check 하지 않는 이유는 계속 유망하면 row를 하나씩 증가하면서 다음번 위치에 놓을 것임
    // 그니까 같은 행에 0을 연속해서 놓는 경우는 없으니까 지금 같은 열인지 아니면 대각선인지의 여부만 check 한 것임

    // row를 매개변수로 받아서 현재 행까지 Q을 놓은 곳까지 검사
    public static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            // board 상에 row 행에 현재 놓여진 Q의 위치랑 다른 행에 놓여진 Q의 위치가 같은 열에 있으면 X
            // or 대각선 check => board의 위치에 대한 차이랑 row-i 값이 Math.abs()랑 같으면 대각선임
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2

        //1 3 0 2
        //2 0 3 1
        //경우의 수: 2
    }
}
