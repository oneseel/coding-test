import java.io.*;
import java.util.*;

class Main {
    private static List<List<Node>> graph; // 인접 리스트
    private static int[] distances; // 최단 거리 배열
    private static boolean[] visited; // 방문 여부 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        distances = new int[V + 1]; // 시작 노드로부터 각 노드까지의 거리
        Arrays.fill(distances, Integer.MAX_VALUE); // 거리를 무한대로 초기화
        distances[K] = 0; // 시작 노드의 거리는 0으로 설정

        visited = new boolean[V + 1];

        // 간선 정보 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 그래프에 간선 추가
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘 실행
        dijkstra(K);

        // 시작 정점 K로부터 다른 모든 정점까지의 최단 거리 출력
        for (int i = 1; i <= V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distances[i]);
            }
        }
    }

    // 다익스트라 알고리즘을 통한 최단 경로 계산
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.getEnd();
            
            if (visited[currentNode]) continue; // 이미 방문한 노드는 무시
            visited[currentNode] = true; // 노드를 방문 처리
            
            for (Node neighbor : graph.get(currentNode)) {
                int neighborNode = neighbor.getEnd();
                int newDist = distances[currentNode] + neighbor.getWeight();
                
                if (newDist < distances[neighborNode]) { // 더 짧은 경로 발견 시 거리 갱신
                    distances[neighborNode] = newDist;
                    pq.offer(new Node(neighborNode, newDist)); // 갱신된 거리로 노드를 큐에 추가
                }
            }
        }
    }
}

// 간선을 나타내는 Node 클래스
class Node {
    private int end; // 목적지 노드
    private int weight; // 간선의 가중치

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}
