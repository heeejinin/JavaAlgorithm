// 알고리즘 - 최단 경로 알고리즘
// 플로이드-워셜

public class Main {

    static int[][] dist;

    // MaxValue로 설정 시, + 어떤 값이 되면 오버플로우로 -값이 됨
    // 그럼 최단 경로 값이 되므로 이를 방지하기위해 충분히 큰 값으로 설정
    static final int INF = 1000000000;


    public static void floydWarshall(int v, int e, int[][] data, int start) {
        dist = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (i != j) { // 대각선(본인 값)이 아닌 값은 인피니티 값
                    dist[i][j] = INF;
                }
            }
        }

        // 그래프 구성
        // 인접 노드 업데이트
        for (int i = 0; i < e; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];
        }

        // 각 정점을 거쳐서 업데이트 되는 경우(실질적으로 거리 정보 업데이트)
        for (int k = 1; k < v + 1; k++) {
            // i -> j (k를 거쳐서 가는 경우가 짧을 때 업데이트)
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (dist[i][j] >= INF) {
                    System.out.printf("%5s ", "INF");
                } else {
                    System.out.printf("%5d ", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test code
        // 음수 사이클이 없는 경우
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        // 음수 사이클이 있는 경우
        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
