// Question 1

import java.util.*;

public class main {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static Node[] tree;
    static int[] key;
    static int K;
    static int count = 0;

    static void dfs(int current, int parent, int xorValue) {

        if (xorValue >= K) {
            count++;
        }

        Node temp = tree[current];

        while (temp != null) {

            int child = temp.value;

            if (child != parent) {

                int newXor = xorValue ^ key[child];

                dfs(child, current, newXor);
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        key = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            key[i] = sc.nextInt();
        }

        tree = new Node[N + 1];

        for (int i = 0; i < N - 1; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            Node a = new Node(v);
            a.next = tree[u];
            tree[u] = a;

            Node b = new Node(u);
            b.next = tree[v];
            tree[v] = b;
        }

        dfs(1, 0, key[1]);

        System.out.println(count);

        sc.close();
    }
}
