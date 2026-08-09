import java.util.*;

public class main2 {

    static class Node {
        int city;
        Node next;

        Node(int city) {
            this.city = city;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read N, M and D
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        Node[] graph = new Node[N + 1];

        for (int i = 0; i < M; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            Node a = new Node(v);
            a.next = graph[u];
            graph[u] = a;

            Node b = new Node(u);
            b.next = graph[v];
            graph[v] = b;
        }

        int[] distance = new int[N + 1];

        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        distance[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            Node temp = graph[current];

            while (temp != null) {

                int nextCity = temp.city;

                if (distance[nextCity] == -1) {

                    distance[nextCity] =
                            distance[current] + 1;

                    queue.add(nextCity);
                }

                temp = temp.next;
            }
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {

            if (distance[i] != -1 && distance[i] <= D) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}