import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        int[] scholarship = new int[N];

        for (int i = 0; i < N; i++) {
            scholarship[i] = sc.nextInt();
        }

        Arrays.sort(scholarship);

        int count = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {

            if (sum + scholarship[i] <= B) {
                sum = sum + scholarship[i];
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
