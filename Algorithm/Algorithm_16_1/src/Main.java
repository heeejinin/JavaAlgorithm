// 알고리즘 - 최단 경로 알고리즘
// 다익스트라 기본 구현


import java.util.ArrayList;

public class Main {

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // v + 1 => 노드가 1부터 시작하기 때문에 (나중에 0번 쪽은 사용하지 않을 것임)
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int i = 0; i < data.length; i++) {
            //다른 노드로의 얼마만큼의 비용이 드는지
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        // 최단거리를 기록할 DP용 메모리

        int[] dist = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        // 스타트 위치는 0으로 초기화
        dist[start] = 0;

        // 방문 체크 배열
        boolean[] visited = new boolean[v + 1];

        // 거리 정보 업데이트
        for (int i = 0; i < v; i++) {
            int minDist = Integer.MAX_VALUE; // 가장 짧은 간선 정보를 찾기 위한 임시 변수
            int curIdx = 0;
            for (int j = 1; j < v + 1; j++) {
                // 방문한 적이 없고 기존 minDist보다 작은 경우 minDist 업데이트
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    curIdx = i;
                }
            }

            visited[curIdx] = true;

            // 선택된 노드의 인접 노드에 대해 거리 갱신
            for (int j = 0; j < graph.get(curIdx).size(); j++) {
                Node adjNode = graph.get(curIdx).get(j);
                // 원래 거리 정보보다 (현재 거리 + 이를 거쳐가는 비용)이 더 적은 경우
                if (dist[adjNode.to] > dist[curIdx] + adjNode.weight) {
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            // 거리 정보 값이 업데이트 되지 않고 Integer.MAX_VALUE로 남아있는 경우: 해당 경로가 없는 것
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF "); // INFINITY
            } else {
                System.out.print(dist[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
