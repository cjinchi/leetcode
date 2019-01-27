import java.util.HashMap;
import java.util.Map;

public class _4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abCount = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                abCount.put(sum, abCount.getOrDefault(sum, 0) + 1);
            }
        }

        int total = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                total += abCount.getOrDefault(-sum, 0);
            }
        }
        return total;
    }
}
